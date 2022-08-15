package 第1部分._2数组;

import java.util.Arrays;

/**
 * @author 挚爱之夕
 * @date 2021/11/4 - 11 - 04 - 11:17
 * @Description 第1部分._2数组
 * @Version 1.0
 */
public class _1数组翻转 {
    /*操作原始数组*/
    private static void reverseArray1(int[] array){
        int length = array.length;
        int temp;
        for (int i = 0; i < length / 2; i++) {
            temp = array[i];
            array[i] = array[length-1-i];
            array[length-1-i] = temp;
        }
    }
    /*创建一个新的数组，用原始数组逆序赋值*/
    private static int[] reverseArray2(int[] array){
        int length = array.length;
        int[] newArray = new int[length];

        for (int i = length-1; i >=0 ; i--) {
            newArray[length-i-1] = array[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] r = reverseArray2(a);
        System.out.println(Arrays.toString(r));
    }
}
