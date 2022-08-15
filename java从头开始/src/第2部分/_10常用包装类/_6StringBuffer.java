package 第2部分._10常用包装类;

/**
 * @author 挚爱之夕
 * @date 2021/11/16 - 11 - 16 - 21:59
 * @Description 第2部分.常用包装类
 * @Version 1.0
 */
public class _6StringBuffer {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        //增
        stringBuffer.append(1);
        stringBuffer.append("li").append("harry potter");
        //删 [0,3) 删除
        stringBuffer.delete(0, 3);
        System.out.println(stringBuffer);
        //改 [0,5) 换为ron
        stringBuffer.replace(0,5,"ron");
        System.out.println(stringBuffer);
        //查
        int index = stringBuffer.indexOf("ron");
        System.out.println(index);
        //插入
        stringBuffer.insert(0,"hermione ");
        System.out.println(stringBuffer);
        //长度
        System.out.println(stringBuffer.length());
    }
}
