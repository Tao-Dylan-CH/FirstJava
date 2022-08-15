package 第1部分._2数组;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/4 - 11 - 04 - 22:12
 * @Description 第1部分._2数组
 * @Version 1.0
 */
public class _3数组缩减 {
    private static int[] reduceArray(int[] array){
        if(array.length == 0){
            System.out.println("数组里已经无元素，无法继续缩减");
            return array;
        }
        else{
            int[] newArray = new int[array.length-1];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = array[i];
            }
            System.out.println("已缩减一次,缩减后为");
            System.out.println(Arrays.toString(newArray));
            return newArray;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {1,2,3};
        char choice;
        do {
            a = reduceArray(a);
            System.out.println("是否继续缩减？（Y/N）");
            choice = scanner.next().charAt(0);
        } while (choice != 'N');

    }
}
