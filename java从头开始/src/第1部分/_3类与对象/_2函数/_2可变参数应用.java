package 第1部分._3类与对象._2函数;

/**
 * @author 挚爱之夕
 * @date 2021/11/5 - 11 - 05 - 22:19
 * @Description 第1部分._3类与对象._2函数
 * @Version 1.0
 */
public class _2可变参数应用 {
    public static void main(String[] args) {
        new Student().show("李白",100,99,88,34);
        new Student().show("孙悟空",56,89);
    }
}
class Student{
    void show(String name, double...scores){
        double sums = 0;
        for (int i = 0; i < scores.length; i++) {
            sums += scores[i];
        }
        System.out.println(name + " :" + scores.length + "门课，" + "总分：" + sums);
    }
}

