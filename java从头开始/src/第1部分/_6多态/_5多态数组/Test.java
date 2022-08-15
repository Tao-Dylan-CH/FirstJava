package 第1部分._6多态._5多态数组;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 20:53
 * @Description 第1部分._6多态._5多态数组
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0] = new Person("dumbledore", 40);
        people[1] = new Student("Harry",18,99);
        people[2] = new Student("Ron",19,100);
        people[3] = new Teacher("snap",40,5000);
        people[4] = new Teacher("James Gosling",59,10000);
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].say());
            if(people[i] instanceof Student){
                ((Student) people[i]).study();
            }else if(people[i] instanceof Teacher){
                Teacher teacher = (Teacher) people[i];
                teacher.teach();
            }else if(people[i] instanceof Person){

            }else{
                System.out.println("类型有误，请检查。");
            }
        }
    }
}
