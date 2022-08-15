package 第2部分._12集合;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 12:49
 * @Description 第2部分._12集合
 * @Version 1.0
 */
public class _9CollectionsDemo {
    public static void main(String[] args) {
        //对List的操作
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(0);
        System.out.println(numbers);
        //1.排序
        Collections.sort(numbers);
        System.out.println(numbers);
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(numbers);
        //2.翻转
        Collections.reverse(numbers);
        System.out.println(numbers);
        //3.随机打乱
        Collections.shuffle(numbers);
        System.out.println(numbers);
        //4.交换
        Collections.swap(numbers, 0, 1);
        System.out.println(numbers);
        //5.最大、最小
        System.out.println("最大：" + Collections.max(numbers));
        //可传比较器
        System.out.println("最大：" + Collections.max(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }));
        System.out.println("最小：" + Collections.min(numbers));
        //6.出现次数
        System.out.println("次数：" + Collections.frequency(numbers, 5));
        //7.拷贝
        List<Integer> dest = new ArrayList<>();
        //需要dest指定大小,大于等于原List
        for (int i = 0; i < numbers.size(); i++) {
            dest.add(-1);
        }
        Collections.copy(dest, numbers);
        System.out.println("dest:" + dest);
        //8.替换
        Collections.replaceAll(numbers, 2, 222);
        System.out.println(numbers);
    }
}
