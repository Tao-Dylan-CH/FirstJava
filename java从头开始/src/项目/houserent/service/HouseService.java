package 项目.houserent.service;

import 项目.houserent.domain.House;

/**
 * @author 挚爱之夕
 * @date 2021/11/10 - 11 - 10 - 11:48
 * @Description 项目.houserent.service
 * @Version 1.0
 */
public class HouseService {

    private House[] houses; //保存house对象
    private int houseNumber = 1;   //当前房源个数
    private int idCounter = 1;      //自动编号
    public HouseService(int size){
        //
        houses = new House[size];
        houses[0] = new House(1,"李白","15155786456","长宁区", 2000, "未出租");
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newHouse){
        if(houseNumber == houses.length){
            House[] newHouses = new House[houseNumber*2];
            for (int i = 0; i < houseNumber; i++) {
                newHouses[i] = houses[i];
            }
            houses = newHouses;
        }
        //ID自增长机制
        newHouse.setId(++idCounter);
        houses[houseNumber++] = newHouse;
        return true;
    }

    public House findById(int id){
        for (int i = 0; i < houseNumber; i++) {
            if(houses[i].getId() == id){
                return houses[i];
            }
        }
        return null;
    }
    public int findOfIndex(int id){
        int index = -1;
        for (int i = 0; i < houseNumber; i++) {
            if(houses[i].getId() == id){
                index = i;
            }
        }
        return index;
    }

    public boolean delete(int deleteId){
        int index = -1;
        for (int i = 0; i < houses.length; i++) {
            if(deleteId == houses[i].getId()){
                index = i;
            }
        }
        if(index == -1)
            return false;
        //向前填空
        for (int i = index; i < houseNumber-1; i++) {
            houses[i] = houses[i+1];
        }
        //最后一个房源赋值为空，当前房源数减1
        houses[--houseNumber] = null;
        return true;
    }

    public boolean modify(int modifyId, String name, String phone, String address, double rent, String state){
        int index = findOfIndex(modifyId);
        if(index == -1){
            return false;
        }
        if(name.length()!= 0)
            houses[index].setName(name);
        if(phone.length() != 0)
            houses[index].setPhone(phone);
        if(address.length() != 0)
            houses[index].setAddress(address);
        if(rent !=  0)
            houses[index].setRent(rent);
        if(state.length() != 0)
            houses[index].setState(state);
        return true;
    }

    public House[] list(){
        return houses;
    }

}
