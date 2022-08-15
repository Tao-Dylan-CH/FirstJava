package 第2部分._12集合.作业;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author 挚爱之夕
 * @date 2021/11/22 - 11 - 22 - 21:46
 * @Description 第2部分._12集合.作业
 * @Version 1.0
 */
public class _1HashSet实践 {
    public static void main(String[] args) {
        Set<Employ> hashSet = new HashSet<>();
        hashSet.add(new Employ("张三", 18));
        hashSet.add(new Employ("张三", 18));
        hashSet.add(new Employ("张三", 20));
        System.out.println(hashSet);
    }
}
class Employ{
    private String name;
    private int age;

    public Employ(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return age == employ.age && Objects.equals(name, employ.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employ{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
