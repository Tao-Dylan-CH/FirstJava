package 第2部分._12集合;

import java.util.ArrayList;

/**
 * @author 挚爱之夕
 * @date 2021/11/20 - 11 - 20 - 17:07
 * @Description 第2部分._12集合
 * @Version 1.0
 */
public class _2Collection方法 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        //add
        arrayList.add("potter");
        arrayList.add(18);
        arrayList.add(true);
        System.out.println(arrayList);
        //remove
        arrayList.remove(true);
        System.out.println(arrayList);
        //size
        System.out.println(arrayList.size());
        //isEmpty
        System.out.println(arrayList.isEmpty());
        //contains
        System.out.println(arrayList.contains("potter"));
        //addAll
        ArrayList<Object> list = new ArrayList<>();
        list.add("12");
        arrayList.addAll(list);
        System.out.println(arrayList);
        //clear
        arrayList.clear();
        System.out.println(arrayList);
    }
}
