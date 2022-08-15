package 第2部分._11常用类._1Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 挚爱之夕
 * @date 2021/11/17 - 11 - 17 - 10:31
 * @Description 第2部分._11Array
 * @Version 1.0
 */
public class _2模拟sort接口排序 {
    public static void main(String[] args) {
        int[] a = {8,5,2,12,4,1};
        bubbleSort(a, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int)o1 - (int)o2;
            }
        });
        System.out.println(Arrays.toString(a));
    }
    public void bubbleSort(int[] array){
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void bubbleSort(int[] array, Comparator t){
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(t.compare(array[j], array[j+1]) > 0){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
