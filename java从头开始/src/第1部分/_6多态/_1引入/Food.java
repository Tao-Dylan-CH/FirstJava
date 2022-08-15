package 第1部分._6多态._1引入;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 17:11
 * @Description 第1部分._6多态._1引入
 * @Version 1.0
 */
public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Fish extends Food{
    public Fish(String name) {
        super(name);
    }
}

class Bone extends Food{
    public Bone(String name) {
        super(name);
    }
}
