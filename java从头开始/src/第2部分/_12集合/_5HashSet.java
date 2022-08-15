package 第2部分._12集合;

/**
 * @author 挚爱之夕
 * @date 2021/11/21 - 11 - 21 - 22:28
 * @Description 第2部分._12集合
 * @Version 1.0
 */
public class _5HashSet {
    public static void main(String[] args) {
        //模拟HashSet底层（HashMap底层 结构）

        //1.创建一个数组，类型是Node[]
        Node[] table = new Node[16];
        //2.创建节点
        Node john = new Node("john", null);
        table[2] = john;

        Node jack = new Node("jack", null);
        john.next = jack;   //挂载节点

        Node luck = new Node("luck", null);
        table[3] = luck;

    }

}
class Node{
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}