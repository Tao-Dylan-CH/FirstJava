package 第3部分._5Jdbc和连接池._11BasicDao.test;

import org.junit.jupiter.api.Test;
import 第3部分._5Jdbc和连接池._11BasicDao.dao.ActorDAO;
import 第3部分._5Jdbc和连接池._11BasicDao.dao.GoodsDAO;
import 第3部分._5Jdbc和连接池._11BasicDao.domain.Actor;
import 第3部分._5Jdbc和连接池._11BasicDao.domain.Goods;

import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 20:26
 * @Description 第3部分._5Jdbc和连接池._11BasicDao.test
 * @Version 1.0
 * 测试ActorDao 对 actor表的操作
 */
public class TestDAO {
    @Test
    public void testQueryMultiply(){
        ActorDAO actorDao = new ActorDAO();
        String sql = "select * from actor where id >= ?";
        List<Actor> actors =
                actorDao.queryMultiply(sql, 1);
        for (Actor actor:actors
             ) {
            System.out.println(actor);
        }
    }
    @Test
    public void testQuerySignal(){
        ActorDAO actorDao = new ActorDAO();
        String sql = "select * from actor where id = ?";
        Actor actor = actorDao.querySignal(sql, 1);
        System.out.println(actor);
    }
    @Test
    public void testQueryScalar(){
        ActorDAO actorDao = new ActorDAO();
        String sql = "select name from actor where id = ?";
        Object o = actorDao.queryScalar(sql, 1);
        System.out.println(o);
    }
    @Test
    public void testDML(){
        ActorDAO actorDao = new ActorDAO();
        String sql = "insert into actor values(null,?,?,?,?)";
        int update = actorDao.update(sql,  "孙悟空", "男", "202-9-9", "110");
        System.out.println(update);
    }
    @Test
    public void testGoodsDAO(){
        GoodsDAO goodsDAO = new GoodsDAO();
        String sql = "select * from goods";
        List<Goods> goods = goodsDAO.queryMultiply(sql, Goods.class);
        for (Goods g:goods
             ) {
            System.out.println(g);
        }
    }
}
