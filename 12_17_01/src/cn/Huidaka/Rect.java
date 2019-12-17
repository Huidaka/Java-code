package cn.Huidaka;

interface IShape {
    abstract void draw() ; // 即便不写public，也是public
 }

 class Rect implements IShape {
    public void draw() {          //必须加public，因为实现接口的方法访问权限不能小于接口
         System.out.println("□"); //权限更加严格了，所以无法覆写。
     }
 }
