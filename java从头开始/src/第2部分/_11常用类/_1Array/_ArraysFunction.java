package 第2部分._11常用类._1Array;

import java.util.Arrays;
import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2021/11/17 - 11 - 17 - 10:43
 * @Description 第2部分._11Array
 * @Version 1.0
 */
public class _ArraysFunction {
    public static void main(String[] args) {
        int[] a = {1,3,5,7};
        int index = Arrays.binarySearch(a, 1);
        System.out.println(index);
        //没找到返回 -(low+1) low为应在的下标
        index = Arrays.binarySearch(a, 8);//-5
        System.out.println(index);
        //copy
        int[] b = Arrays.copyOf(a, 2);  //[1,3]
        System.out.println(Arrays.toString(b));
        b = Arrays.copyOf(a, 5);  //[1,3,5,7,0]
        System.out.println(Arrays.toString(b));
        //数组元素填充
        Arrays.fill(b, 99);
        System.out.println(Arrays.toString(b));//[99, 99, 99, 99, 99]
        //判断数组元素是否相等
        int[] a1 = {1,2,3};
        int[] a2 = {1,2,3};
        System.out.println(Arrays.equals(a1,a2));
        //元素转为List
        /*
        返回的 list 编译类型 List（接口）
        运行类型    Arrays 中的静态内部类 ArrayList
         */
        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println(list);
        System.out.println(list.getClass());
    }
}
