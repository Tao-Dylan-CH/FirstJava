package 第2部分._11常用类._1Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 挚爱之夕
 * @date 2021/11/17 - 11 - 17 - 10:23
 * @Description 第2部分._11Array
 * @Version 1.0
 */
public class _1ArraysSort {
    public static void main(String[] args) {
        Integer[] a = {8,5,2,12,4,1};
        Arrays.sort(a,new Comparator<Integer>(){ //匿名类
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 -  o2;
            }
        });
        System.out.println(Arrays.toString(a));
    }
}

/*
        Arrays.sort(a,new Comparator(){ //匿名类
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)o1 - (Integer) o2;
            }
        });
 */