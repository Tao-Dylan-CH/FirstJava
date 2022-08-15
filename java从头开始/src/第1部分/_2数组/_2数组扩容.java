package 第1部分._2数组;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/4 - 11 - 04 - 11:29
 * @Description 第1部分._2数组
 * @Version 1.0
 */
public class _2数组扩容 {
    private static int[] arrayExpansion(int[] array, int element){
        int[] newArray = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length-1] = element;
        array = newArray;   //array是引用，引用换地址，不影响指向的地址,所以return一个新的数组
        System.out.println("添加后：");
        System.out.println(Arrays.toString(array));
        return newArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {1,2,3};
        char b = 'Y';
        while(b == 'Y') {
            System.out.println("输入增加元素：");
            int n = scanner.nextInt();
            a = arrayExpansion(a, n);
            System.out.println("是否继续添加？(Y/N)");
            b = scanner.next().charAt(0);
            if (b == 'N')
                break;
        }
        System.out.println("你退出了添加，最终数组a为:");
        System.out.println(Arrays.toString(a));
    }
}
