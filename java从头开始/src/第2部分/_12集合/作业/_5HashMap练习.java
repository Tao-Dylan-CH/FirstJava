package 第2部分._12集合.作业;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 15:27
 * @Description 第2部分._12集合.作业
 * @Version 1.0
 */
public class _5HashMap练习 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);
        //修改jack工资
        map.replace("jack", 2600);
        //每人工资加100
        for(Map.Entry<String, Integer> entries: map.entrySet()){
            String key = entries.getKey();
            Integer value = entries.getValue();
            map.replace(key, value + 100);
        }
        //遍历集合中所有员工
        Set<String> sets = map.keySet();
        for (String name:sets
             ) {
            System.out.print(name + "\t");
        }
        System.out.println();
        //遍历集合中所有工资
        Collection<Integer> values = map.values();
        for (Integer i:values
        ) {
            System.out.print(i + "\t");
        }

        //遍历
        System.out.println();
        for (Map.Entry<String, Integer> entry:map.entrySet()
             ) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}