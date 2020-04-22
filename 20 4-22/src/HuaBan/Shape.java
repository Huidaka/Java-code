package HuaBan;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;

public class Shape {
    public int x1,x2,y1,y2;
    public Stroke stroke;
    public Color color;
    public String type;
    public Image img;
    public String text;

    public Shape(int x1,int y1,int x2,int y2,Color color,
                 Stroke stroke,String type){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.color=color;
        this.stroke=stroke;
        this.type=type;
    }

    public Shape(int x1,int y1,int x2,int y2,
                 Image img,String type){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.img=img;
        this.type=type;
    }

    public Shape(int x1,int y1,
                 String text,String type){
        this.x1=x1;
        this.y1=y1;
        this.text=text;
        this.type=type;
    }

    public void draw(Graphics2D g){

        if(type.equals("Line") || type.equals("Pencil")){
            g.setColor(color);
            g.setStroke(stroke);
            g.drawLine(x1, y1, x2, y2);
        }
        else if(type.equals("Image")){
            g.drawImage(img,x1,y1,x2,y2,null);
        }
        else if(type.equals("Rect")){
            g.setColor(color);
            g.setStroke(stroke);
            g.drawRect(x1, y1, x2, y2);
        }
        else if(type.equals("Oval")){
            g.setColor(color);
            g.setStroke(stroke);
            g.drawOval(x1, y1, x2, y2);
        }
        else if(type.equals("fillRect")){
            g.setColor(color);
            g.setStroke(stroke);
            g.fillRect(x1, y1, x2, y2);
        }
        else if(type.equals("RoundRect")){
            g.setColor(color);
            g.setStroke(stroke);
            g.drawRoundRect(x1, y1, x2, y2, 10, 10);
        }
        else if(type.equals("fillOval")){
            g.setColor(color);
            g.setStroke(stroke);
            g.fillOval(x1, y1, x2, y2);
        }
        else if(type.equals("fillArc")){
            g.setColor(color);
            g.setStroke(stroke);
            g.fillArc(x1, y1, x2, y2,0,-90);
        }
        else if(type.equals("Text")){
            g.drawString(text, x1, y1);
        }
        else if(type.equals("Triangle")){
            g.setColor(color);
            g.setStroke(stroke);
            g.drawLine(x1,y1,x2,y2);
	    	g.drawLine(2*x1-x2, y2, x2, y2);
	    	g.drawLine(x1,y1,2*x1-x2, y2);
        }
    }
}
