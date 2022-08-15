package 第2部分._12集合;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 11:34
 * @Description 第2部分._12集合
 * @Version 1.0
 */
public class _8TreeMap {
    public static void main(String[] args) {
        Map<String, String> map1 = new TreeMap<>();
        map1.put("2", "Harry Potter");
        map1.put("1", "Ron Weasley");
        map1.put("3", "Hermione Grange");
        System.out.println(map1);
        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
