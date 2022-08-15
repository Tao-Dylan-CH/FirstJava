package 第1部分._6多态._1引入;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 17:11
 * @Description 第1部分._6多态._1引入
 * @Version 1.0
 */
public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void feed(Dog dog,Bone bone){
//        System.out.println("主人"+ name + "给" + dog.getName() + "吃" + bone.getName());
//    }
//
//    public void feed(Cat cat,Fish fish){
//        System.out.println("主人"+ name + "给" + cat.getName() + "吃" + fish.getName());
//    }
    //...如果动物很多，要重载很多次feed()

    /*改为*/
    public void feed(Animal animal,Food food){
        System.out.println("主人"+ name + "给" + animal.getName() + "吃" + food.getName());
    }
}
