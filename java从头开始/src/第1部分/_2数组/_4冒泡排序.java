package 第1部分._2数组;

import java.util.Arrays;

/**
 * @author 挚爱之夕
 * @date 2021/11/4 - 11 - 04 - 22:27
 * @Description 第1部分._2数组
 * @Version 1.0
 */
public class _4冒泡排序 {
    private static void BubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "轮:");
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 6, 8, 1, 0, 19};
        BubbleSort(a);
    }
}
