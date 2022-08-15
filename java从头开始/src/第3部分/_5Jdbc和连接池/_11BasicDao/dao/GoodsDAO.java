package 第3部分._5Jdbc和连接池._11BasicDao.dao;

import 第3部分._5Jdbc和连接池._11BasicDao.domain.Goods;

import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 20:59
 * @Description 第3部分._5Jdbc和连接池._11BasicDao.dao
 * @Version 1.0
 * 操作商品表
 */
public class GoodsDAO extends BasicDAO<Goods>{
    public List<Goods> queryMultiply(String sql, Object... parameters){
        return queryMultiply(sql, Goods.class, parameters);
    }
    public Goods querySignal(String sql, Object... parameters){
        return querySignal(sql, Goods.class, parameters);
    }
}
