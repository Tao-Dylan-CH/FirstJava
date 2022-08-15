package 第2部分._12集合;

import java.util.*;

/**
 * @author 挚爱之夕
 * @date 2021/11/23 - 11 - 23 - 21:58
 * @Description 第2部分._12集合
 * @Version 1.0
 */
public class _6MapDemo {
    public static void main(String[] args) {
        Map<String, String> spouses = new HashMap<>();
        //增
        spouses.put("harry", "ginny");
        spouses.put("ron", "hermione");
        spouses.put("葛小伦", "天使彦");
        spouses.put("唐三", "小舞");
        spouses.put("奥斯卡", "宁荣荣");
        //删
//        spouses.remove("奥斯卡");
        //查
        String female = spouses.get("harry");
        System.out.println(female);
        //清空
//        spouses.clear();
        /*迭代方式*/
        /*第一组：先取出所有key, 通过key得value*/

        //1.增强for
        System.out.println("keySet:增强for");
        Set<String> keys = spouses.keySet();
        for (String key:keys
             ) {
            System.out.println(key + " 和 " + spouses.get(key));
        }
        System.out.println("-------------------------------");
        //2.迭代器
        System.out.println("keySet:迭代器");
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            System.out.println(key + " 和 " + spouses.get(key));
        }
        System.out.println("-------------------------------");

        /*第二组：如果只关心值，不管key,可以取出所有value，再遍历 */

        //1.增强for
        System.out.println("values:增强for");
        Collection<String> values = spouses.values();
        for (String girl:values
             ) {
            System.out.println(girl + "\t");
        }
        System.out.println();
        System.out.println("-------------------------------");

        //2.迭代器
        System.out.println("values:迭代器");
        Iterator<String> iterator1 = values.iterator();
        while(iterator1.hasNext()){
            String girl = iterator1.next();
            System.out.println(girl + "\t");
        }
        System.out.println("-------------------------------");

        /*第三组：通过entrySet */
        Set<Map.Entry<String, String>> entries = spouses.entrySet();//键值对的集合

        //1.增强for
        System.out.println("entrySet:增强for");
        for (Map.Entry<String, String> entry:entries
             ) {
            System.out.println(entry.getKey() + " 和 " + entry.getValue());
        }
        System.out.println("-------------------------------");

        //2.迭代器
        System.out.println("entrySet:迭代器");
        Iterator<Map.Entry<String, String>> iterator2 = entries.iterator();
        while(iterator2.hasNext()){
            Map.Entry<String, String> spouse = iterator2.next();
            System.out.println(spouse.getKey() + " 和 " + spouse.getValue());
        }
    }
}
