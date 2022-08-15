package 第2部分._13泛型.作业;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 16:11
 * @Description 第2部分._13泛型.作业
 * @Version 1.0
 */
public class 作业2 {
    public static void main(String[] args) {

    }
    @Test
    public void test(){
        Dao<User> dao = new Dao<>();
        User user = new User("李明", 11001, 18);
        dao.save("1", user);
        dao.save("2", new User("张磊", 11000, 20));
        List<User> list = dao.list();
        System.out.println(list);
    }

    static class Dao<T>{
        Map<String, T> map = new HashMap<>();
        public void save(String id, T entity){
            map.put(id, entity);
        }
        public T get(String id){
            return map.get(id);
        }
        public void update(String id, T newEntity){
            map.replace(id, newEntity);
        }
        public List<T>  list(){
            return new ArrayList<>(map.values());
        }
        public void delete(String id){
            map.remove(id);
        }
    }
    static class User{
        private String name;
        private int id;
        private int age;

        public User(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    '}';
        }
    }
}
