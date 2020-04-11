package Huidaka;

import java.util.*;

public class TestHasMap {
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(r.nextInt(60000));
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer integer : list){
            if(!map.containsKey(list.get(integer))){
                map.put(integer,1);
            }
            else{
                map.put(integer,map.get(integer)+1);
            }
        }
        //通过迭代器遍历HasMap
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while ( iterator.hasNext() ) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println("重复数字："+ entry.getKey()+"重复数字出现次数："+ entry.getValue());
        }
        //通过键值对映射方法遍历HasMap
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println("重复数字："+ entry.getKey()+"重复数字出现次数："+ entry.getValue());
        }
        //通过key值遍历
        for (Integer integer : map.keySet()) {
            System.out.println("重复数字："+ integer +"重复数字出现次数："+ map.get(integer));
        }
        //通过value值遍历
    }
}
