package sample;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Controller {
    /*
    @FXML
    public TextField input;
    @FXML
    public Text output;
    */

    @FXML
    public LineChart<Double, Double> chart;
    @FXML
    public TableView<Host> tableView;

    private double x = 0;

    @FXML
    public void buttonHasClicked(Event event) {
        try (Socket socket = new Socket("127.0.0.1", 8001)) {
            socket.getOutputStream().write("list\r\n".getBytes("ASCII"));
            socket.getOutputStream().flush();

            Scanner s = new Scanner(socket.getInputStream());
            while (s.hasNextLine()) {
                String hostname = s.nextLine();
                System.out.println(hostname);
                ObservableList<Host> items = tableView.getItems();
                Host host = new Host(hostname);
                items.removeAll();
                items.add(host);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("Hello World");
//        // 1. 读取 TextField 中的内容
//        String text = input.getText();
//        System.out.println(text);
//        // 2. 把读取到的内容写到 Text 中
//        output.setText(text);
//        try {
//            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
//            stage.setTitle(input.getText());
//            stage.setScene(new Scene(root, 300, 275));
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void refreshChart(ActionEvent event) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {

                        Platform.runLater(() -> {
                            ObservableList<XYChart.Series<Double, Double>> list = chart.getData();
                            XYChart.Series<Double, Double> series;
                            if (list.size() == 0) {
                                series = new XYChart.Series<>();
                                list.add(series);
                            } else {
                                series = list.get(0);
                            }

                            XYChart.Data<Double, Double> data = new XYChart.Data<>(x, Math.sin(x));
                            x += 0.1;
                            series.getData().add(data);
                        });

                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
