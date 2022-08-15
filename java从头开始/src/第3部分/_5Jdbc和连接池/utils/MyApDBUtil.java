package 第3部分._5Jdbc和连接池.utils;

import java.util.ArrayList;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 11:20
 * @Description 第3部分._5Jdbc和连接池.utils
 * @Version 1.0
 * 模拟ApDbUtil
 */
public class MyApDBUtil {
    public static ArrayList<Actor> actors;
    static {
        actors = new ArrayList<>();
    }
    public static void addActor(Actor actor){
        actors.add(actor);
    }
}
