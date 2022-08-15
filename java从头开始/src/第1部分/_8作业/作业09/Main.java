package 第1部分._8作业.作业09;

/**
 * @author 挚爱之夕
 * @date 2021/11/9 - 11 - 09 - 21:22
 * @Description 第1部分._8作业.作业09
 * @Version 1.0
 */
public class Main {
    static void school(Person p){
        if(p instanceof Student)
            ((Student) p).study();
        else if(p instanceof Teacher)
            ((Teacher)p).teach();
    }
    static void sortByAge(Person[] p){
        for (int i = 0; i < p.length-1; i++) {
            for (int j = i+1; j < p.length; j++) {
                if(p[i].getAge()<p[j].getAge()){
                    Person temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Person[] p = new Person[4];
        p[0] = new Student("李华",18,"男","11001");
        p[1] = new Student("张三丰",20,"男","10012");
        p[2] = new Teacher("李四",40,"男",4);
        p[3] = new Teacher("王雅",30,"女",3);

        for (int i = 0; i < p.length; i++) {
            school(p[i]);
        }
        sortByAge(p);
        for (int i = 0; i < p.length; i++) {
            p[i].printBaseInformation();
            System.out.println();
        }
    }
}
