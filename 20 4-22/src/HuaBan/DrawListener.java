package HuaBan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

//先继承类，后继承接口
public class DrawListener extends MouseAdapter implements ActionListener{

    private int x1, y1, x2, y2,x3,y3,sx,sy,ex,ey;
    private Graphics2D g2;
    private String str = "Line";
    private Color color;
    private int flag = 1;//用于标记是否是第一次画线

    public void setG(Graphics g){
        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);// 设置画笔开启抗锯齿

    }

    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();//getSource返回事件源类型，也可以用getActionCommand返回String类型

        if(button.getText() != "")//如果为图形按钮
            str = button.getText();

        else{
            color = button.getBackground();
            System.out.println("color"+color);
        }
    }

    public void mouseClicked(MouseEvent e){
        System.out.println("点击");//按下和释放要在同一位置才是点击
        x2 = e.getX();
        y2 = e.getY();
    	//画空心矩形
    	if(str.equals("Rect")){
    		Shape s = new Shape(x2,y2,80,40,color,new BasicStroke(1),"Rect");
    		s.draw(g2);
     	}
     	//画填充矩形
    	if(str.equals("fillRect")){
    		Shape s = new Shape(x2,y2,80,40,color, new BasicStroke(1),"fillRect");
     			s.draw(g2);
     	}
    	//画圆角矩形
    	if(str.equals("RoundRect")){
    		Shape s = new Shape(x2,y2,80,40,color,new BasicStroke(1),"fillRect");
				s.draw(g2);
	 	}
	 	//画空心圆
		if(str.equals("Oval")){
	 		Shape s = new Shape(x2,y2,80,40,color,
                    new BasicStroke(1),"Oval");
				s.draw(g2);
		}
		//画填充圆
		if(str.equals("fillOval")){
			Shape s = new Shape(x2,y2,80,40,color,
                    new BasicStroke(1),"fillOval");
				s.draw(g2);
		}
		//画填充弧
		if(str.equals("fillArc")){
	 		Shape s = new Shape(x2,y2,80,80,color,
                    new BasicStroke(1),"fillArc");
				s.draw(g2);
		}
		//画图片
		if(str.equals("Image")){
			//先用ImageIcon设置路径，再获取图片(绝对路径)
			ImageIcon icon = new ImageIcon("C:\\Users\\lenovo\\Desktop\\background1.jpg");
			Image img = icon.getImage();
	 		Shape s = new Shape(x2,y2,200,150,
                    img,"Image");
				s.draw(g2);
		}
		//画文本
		if(str.equals("Text")){
			String text = "Hello World";
			Font font = new Font("华文行楷", Font.BOLD + Font.ITALIC, 26);//字体，粗体，斜体，大小
			g2.setFont(font);
			Shape s = new Shape(x2,y2,text,"Text");
				s.draw(g2);
		}
		//画任意多边形
		if(str.equals("Polygon")){
			if(flag == 2){
				Shape s = new Shape(ex,ey,x2,y2,color,new BasicStroke(1),"Line");
				s.draw(g2);
				ex = x2;
				ey = y2;
			}
			//如果与起点较近或鼠标双击，则闭合多边形
	 		if((Math.abs(sx-x2)<10 && Math.abs(sy-y2)<10) ||(e.getClickCount()==2)){
	 			Shape s = new Shape(sx,sy,x2,y2,color,new BasicStroke(1),"Line");
	 			s.draw(g2);
				flag = 1;
			}
		}
	}

     public void mousePressed(MouseEvent e){
     	x1 = e.getX();
    	y1 = e.getY();
     	g2.setColor(color);
     	if(flag == 1){
     		sx = x1;
    		sy = y1;
    	}
    }

    public void mouseReleased(MouseEvent e){
    	x2 = e.getX();
    	y2 = e.getY();
    	//画直线
    	if(str.equals("Line")){
    		Shape s = new Shape(x1,y1,x2,y2,color,
                    new BasicStroke(1),"Line");
     			s.draw(g2);
    	}
     	//画任意多边形
     	if(str.equals("Polygon")){
     		if(flag == 1){
     			Shape s = new Shape(x1,y1,x2,y2,color,
                            new BasicStroke(1),"Line");
     			s.draw(g2);
    			ex = x2;
    			ey = y2;
    			flag = 2;
    		}
    	}
    	//画等腰三角形
    	if(str.equals("Triangle")){
    		Shape s = new Shape(x1,y1,x2,y2,color,
                    new BasicStroke(1),"Triangle");
    			s.draw(g2);
 	}
  }

    public void mouseDragged(MouseEvent e){
     	x3 = e.getX();
     	y3 = e.getY();

    	//画曲线
    	if(str.equals("Pencil")){
    		Shape s = new Shape(x1,y1,x3,y3,color,new BasicStroke(10),"Pencil");
    		s.draw(g2);
    		x1 = x3;
     		y1 = y3;
    	}
     }
    private Shape[] array;

    private int index=0;

    public void setArray(Shape[] array){
        this.array = array;
    }

}

