package leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * HashMap解决员工重要性问题
 */
public class Solution690_1 {
    public int getImportance(List<Employee> employees, int id) {
        Employee temp = null;
        HashMap<Integer,Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        return getImportance(map,id);
    }
    private int getImportance(HashMap<Integer,Employee> map, int id) {
        Employee temp = map.get(id);
        int im = temp.importance;
        int sum = 0;
        for (int i = 0; i < temp.subordinates.size(); i++) {
            sum += getImportance(map,temp.subordinates.get(i));
        }
        return sum + im;
    }
}
