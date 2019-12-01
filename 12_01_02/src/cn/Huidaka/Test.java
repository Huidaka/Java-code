package cn.Huidaka;

interface	Instrument {
    public abstract void play();
    public abstract void adjust();
}
class Wind implements Instrument{
    public void play() {
        System.out.println("Wind.play()");
    }

    public String what() {
        return "Wind";
    }

    public void adjust() {
    }
}
public class Test {
    static void tune(Instrument i){
        i.play();
    }
    public static void main(String[] args) {
        Wind w = new Wind();
        tune(w);
    }
}
