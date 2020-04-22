package HuaBan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Draw extends JFrame {

    public static void main(String args[]) {
        Draw dr = new Draw();
        dr.showdraw();
    }

    public Shape[] shapeArray = new Shape[1000];//储存图形的数组

    public void showdraw() {
        //继承后JFrame后无需实例化
        this.setTitle("画图板");
        this.setSize(700, 500);
        //frame.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        FlowLayout f1 = new FlowLayout();
        this.setLayout(f1);
        DrawListener lis = new DrawListener();
        //创建图形按钮和颜色按钮
        String[] array = {"Line", "Pencil", "Rect", "Oval", "RoundRect", "fillRect",
                "fillArc", "fillOval", "Text", "Image", "Triangle", "Polygon"};
        for (int i = 0; i < array.length; i++) {
            JButton button = new JButton(array[i]);
            this.add(button);
            button.addActionListener(lis);
        }
        Color[] colorArray = {Color.black, Color.blue,
                Color.green, Color.red};
        for (int i = 0; i < colorArray.length; i++) {
            JButton button = new JButton();
            button.setBackground(colorArray[i]);
            button.setPreferredSize(new Dimension(30, 30));//设置按钮大小
            this.add(button);
            button.addActionListener(lis);
        }
        this.setVisible(true);  //setVisible设置窗体可见，放在所有组件后

        Graphics g = this.getGraphics();
        this.addMouseListener(lis);//用this指代frame可能出错
        this.addMouseMotionListener(lis);
        lis.setG(g);
        lis.setArray(shapeArray);//增加对图形数组的监听
    }

    public void paint(Graphics g){
        super.paint(g);//super为父类
        System.out.println("绘制了");
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0 ; i<shapeArray.length ; i++){
            Shape s = shapeArray[i];
            if(s != null)
                s.draw(g2);
        }

    }

}

