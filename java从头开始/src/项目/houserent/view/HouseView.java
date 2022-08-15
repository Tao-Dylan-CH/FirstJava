package 项目.houserent.view;

/**
 * @author 挚爱之夕
 * @date 2021/11/10 - 11 - 10 - 10:48
 * @Description 项目.houserent.view
 * @Version 1.0
 */

import 项目.houserent.domain.House;
import 项目.houserent.service.HouseService;
import 项目.houserent.utils.Utility;

/**
 * 1.显示界面
 * 2.接受用户的输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;
    private HouseService houseService = new HouseService(10);

    //新增房源
    public void addHouse(){
        System.out.println("==========新增房源==========");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        double rent = Utility.readDouble();
        System.out.print("状态：");
        String state = Utility.readString(3);
        House house = new House(0, name, phone, address, rent, state);
        if(houseService.add(house)){
            System.out.println("添加房源成功");
        }else{
            System.out.println("添加房源失败");
        }
    }
    public void findHouse(){
        System.out.println("==========查找房源==========");
        System.out.print("输入ID：");
        int id = Utility.readInt(0);
        House target = houseService.findById(id);
        if(target == null){
            System.out.println("没有找到。");
        }else{
            System.out.println("找到目标房源：");
            System.out.println("编号\t\t房主\t\t电话\t\t\t\t地址\t\t月租\t\t状态（未出租/已出租）");
            System.out.println(target);
        }
    }
    public void deleteHouse(){
        System.out.println("==========删除房源信息==========");
        System.out.println("请输入待删除房源编号(-1退出):");
        int deleteId = Utility.readInt(0);
        //放弃删除
        if(deleteId == -1){
            System.out.println("放弃删除房源信息。");
            return;
        }
        //提前判读是否存在该编号
        if((houseService.findOfIndex(deleteId) == -1)){
            System.out.println("没有找到该编号，删除失败。");
            return;
        }
        //循环选择
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            houseService.delete(deleteId);
            System.out.println("删除房源信息成功。");
        }else{
            System.out.println("你放弃了删除房源信息。");
        }
    }

    public void modifyHouse(){
        System.out.println("==========修改房源信息==========");
        System.out.println("请输入待修改房源编号(-1退出):");
        int modifyId = Utility.readInt(0);
        if(modifyId == -1){
            System.out.println("放弃修改房源信息。");
            return;
        }
        //提前判读是否存在该编号
        if((houseService.findOfIndex(modifyId) == -1)){
            System.out.println("没有找到该编号，修改失败。");
            return;
        }
        System.out.println("输入修改信息：");
        System.out.print("姓名：");
        String name = Utility.readString(8, "");
        System.out.print("电话：");
        String phone = Utility.readString(12, "");
        System.out.print("地址：");
        String address = Utility.readString(16, "");
        System.out.print("月租：");
        double rent = Utility.readDouble(0);
        System.out.print("状态：");
        String state = Utility.readString(3,"");
        if (houseService.modify(modifyId, name, phone, address, rent, state)) {
            System.out.println("修改成功。");
            System.out.println("编号\t\t房主\t\t电话\t\t\t\t地址\t\t月租\t\t状态（未出租/已出租）");
            System.out.println(houseService.findById(modifyId));
        } else {
            System.out.println("修改失败，编号不存在。");
        }

    }

    //编写listHouse()方法，显示房屋列表
    public void listHouse(){
        System.out.println("==============================房屋列表==============================");
        System.out.println("编号\t\t房主\t\t电话\t\t\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        House[] houses = houseService.list();
        for (House house : houses) {
            if (house != null)
                System.out.println(house);
        }
        System.out.println("房屋信息显示完毕。");
    }

    public void exit(){
        char c = Utility.readConfirmSelection();
        if(c == 'Y')
            loop = false;
    }

    public void mainMenu(){
        do{
            System.out.println("\n==========房屋出租系统==========");
            System.out.println("\t\t1 新 增 房 源");
            System.out.println("\t\t2 查 找 房 源");
            System.out.println("\t\t3 删 除 房 源 信 息");
            System.out.println("\t\t4 修 改 房 源 信 息");
            System.out.println("\t\t5 房 源 列 表");
            System.out.println("\t\t6 退 出");
            System.out.println("请输入你的选择(1-6)：");
            //用户选择
            char key = Utility.readChar();
            switch (key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    modifyHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("输入有误");
            }
        }while(loop);
        System.out.println("退出了房屋出租系统");
    }
}
