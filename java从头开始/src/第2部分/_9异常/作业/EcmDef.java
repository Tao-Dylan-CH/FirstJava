package 第2部分._9异常.作业;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 21:42
 * @Description 第2部分._9异常.作业
 * @Version 1.0
 */
public class EcmDef {
    static double cal(double n1, double n2){
        return n1/n2;
    }

    public static void main(String[] args) {
        try {
            if(args.length != 2)
                throw new ArrayIndexOutOfBoundsException("参数个数不正确。");
            double n1, n2;
            n1 = Double.parseDouble(args[0]);
            n2 = Double.parseDouble(args[1]);
            System.out.println("计算结果是：" + cal(n1, n2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("参数格式不正确，需要输入整数。");
        }
//        }catch (ArithmeticException e){
//            System.out.println("除数不能为0。");
//        }
    }
}
