package 第3部分._5Jdbc和连接池._11BasicDao.domain;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 20:59
 * @Description 第3部分._5Jdbc和连接池._11BasicDao.domain
 * @Version 1.0
 */
public class Goods {
    private int id;
    private String goods_name;
    private double price;
    public Goods(){}

    public Goods(int id, String goods_name, double price) {
        this.id = id;
        this.goods_name = goods_name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + goods_name + '\'' +
                ", price=" + price +
                '}';
    }
}
