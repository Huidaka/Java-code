package sample;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class TableCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {
    @Override
    public TableCell<S, T> call(TableColumn<S, T> param) {
        TableCell<S, T> cell =  new TableCell<S, T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                if (item == getItem()) {
                    return;
                }

                super.updateItem(item, empty);

                if (item == null) {
                    super.setText(null);
                } else {
                    super.setText(item.toString());
                }

                super.setGraphic(null);
            }
        };

        cell.setOnMouseClicked(event -> {
            TableCell<S, T> c = (TableCell<S, T>) event.getSource();
            System.out.println(c.getText().trim());
        });

        return cell;
    }
}
