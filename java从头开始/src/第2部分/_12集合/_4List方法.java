package 第2部分._12集合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2021/11/20 - 11 - 20 - 18:45
 * @Description 第2部分._12集合
 * @Version 1.0
 */
public class _4List方法 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("Harry");
        list.add("Ron");
        //根据索引得到元素
        System.out.println(list.get(0));
        //插入
        list.add(0, "Hermione");
        System.out.println(list);
        //查找
        //从前找
        int index = list.indexOf("Harry");
        System.out.println(index);
        //从后找
        index = list.lastIndexOf("Harry");
        System.out.println(index);
        //替换
        list.set(0, "0");
        System.out.println(list);
        //删除
        list.remove(0);
        System.out.println(list);
        //截取
        List<Object> list1 = list.subList(0, 1);
        System.out.println(list1);
    }
}
