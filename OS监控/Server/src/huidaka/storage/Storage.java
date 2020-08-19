package huidaka.storage;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    //之所以用ConcurrentHashMap是为了线程安全
    public static  ConcurrentHashMap<String,CycleQueue<ReportData>> map  = new ConcurrentHashMap<>();;

    //把文件放入档案室
    public static void put(String hostname, long time, double percent){
        //把文件归档
        ReportData data = new ReportData(hostname,time,percent);
        // 2. 获取 hostname 对应的抽屉
        CycleQueue<ReportData> queue = map.computeIfAbsent(hostname, k -> new CycleQueue<>(60));
        // 3. 把归档后的文件放入抽屉中
        queue.push(data);
    }
    //获取最新的数据
    public static ReportData getNewReportData(String hostname) {
        if(!map.containsKey(hostname)){
            System.out.println("不包含：" + hostname);
            return null;
        }
        return map.get(hostname).pop();
    }
}
