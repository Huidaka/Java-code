package data;

import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    //存放数据的仓库
    public static ConcurrentHashMap<String,CycleQueue<ReportData>> map = new ConcurrentHashMap<>();

    //初始化仓库
    public static void put(String hostName, long time, double percent) {
        ReportData data = new ReportData(hostName,time,percent);
        CycleQueue<ReportData> queue = map.computeIfAbsent(hostName,k->new CycleQueue<>(60));
        queue.push(data);
    }

    //获取仓库数据
    public static ReportData getNewReportData(String hostName) throws RuntimeException{
        if(!map.containsKey(hostName)){
            return null;
        }
        return map.get(hostName).pop();
    }
}
