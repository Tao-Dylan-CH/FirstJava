package 第2部分._8注解;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2021/11/13 - 11 - 13 - 22:01
 * @Description 第2部分._8注解
 * @Version 1.0
 */

public class _3SuppressWarnings {
    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("harry");
        list.add("ron");
        System.out.println(list.get(0));
    }
}

