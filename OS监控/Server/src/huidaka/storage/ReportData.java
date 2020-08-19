package huidaka.storage;

public class ReportData {
    public String hostname;
    public long time;
    public double percent;

    public ReportData(String hostname, long time, double percent) {
        this.hostname = hostname;
        this.time = time;
        this.percent = percent;
    }
}
