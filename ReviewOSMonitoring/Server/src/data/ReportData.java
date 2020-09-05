package data;

public class ReportData {
    public String hostName;
    public long time;
    public double percent;

    public ReportData(String hostName, long time, double percent) {
        this.hostName = hostName;
        this.time = time;
        this.percent = percent;
    }
}
