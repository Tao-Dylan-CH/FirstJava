package 第2部分._12集合;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 11:20
 * @Description 第2部分._12集合
 * @Version 1.0
 */
public class _7TreeSet {
    public static void main(String[] args) {
        //默认的构造方法，没有顺序比较
        Set<String> set = new TreeSet<>();
        set.add("Ron");
        set.add("Hermione");
        set.add("Potter");
        set.add("Apple");
        System.out.println(set);
        //带比较器的构造函数，可自定义排序
        Set<String> sets = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        sets.add("Ron");
        sets.add("Hermione");
        sets.add("Potter");
        sets.add("Apple");
        System.out.println(sets);
    }
}
