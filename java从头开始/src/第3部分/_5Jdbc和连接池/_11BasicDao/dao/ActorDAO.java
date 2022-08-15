package 第3部分._5Jdbc和连接池._11BasicDao.dao;

import 第3部分._5Jdbc和连接池._11BasicDao.domain.Actor;

import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 20:25
 * @Description 第3部分._5Jdbc和连接池._11BasicDao.dao
 * @Version 1.0
 * 继承BasicDAO 包含其所有方法
 * 可以根据业务需求，添加特有方法
 */
public class ActorDAO extends BasicDAO<Actor>{
    public List<Actor> queryMultiply(String sql, Object... parameters){
        return queryMultiply(sql, Actor.class, parameters);
    }
    public Actor querySignal(String sql, Object... parameters){
        return querySignal(sql, Actor.class, parameters);
    }

}
