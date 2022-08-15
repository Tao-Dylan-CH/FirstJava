package 项目.houserent.domain;

/**
 * @author 挚爱之夕
 * @date 2021/11/10 - 11 - 10 - 10:39
 * @Description 项目.houserent.domain
 * @Version 1.0
 */
public class House {
    //编号
    private int id;
    //房主
    private String name;
    //电话
    private String phone;
    //地址
    private String address;
    //月租
    private double rent;
    //状态
    private String state;

    public House(int id, String name, String phone, String address, double rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    @Override
    public String toString() {
        return  id + "\t\t" +
                name + "\t\t" +
                phone + "\t\t" +
                address + "\t" +
                rent + "\t" +
                state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
