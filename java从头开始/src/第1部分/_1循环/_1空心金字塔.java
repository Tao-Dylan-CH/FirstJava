package 第1部分._1循环;

/**
 * @author 挚爱之夕
 * @date 2021/11/3 - 11 - 03 - 21:26
 * @Description 第1部分._1循环
 * @Version 1.0
 */
public class _1空心金字塔 {
    public static void main(String[] args) {
        int n = 5;
        Print.print4(n);
    }
    private static class Print{
        //化繁为简

        /*
         打印矩形
******
******
******
******
******

         */
        static void  print1(int n){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        /*
            打印半个金字塔
*
**
***
****
*****
         */
        static void print2(int n){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        /*
        打印整个金字塔
    *
   ***
  *****
 *******
*********

         */
        static void print3(int n){
            for (int i = 0; i < n; i++) {
                //打印空格
                for (int j = 0; j < n - i - 1; j++) {
                    System.out.print(' ');
                }
                //打印“*”
                for (int j = 0; j < 2*i+1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        /*
        打印空心金子塔

         */
        static void print4(int n){
            for (int i = 0; i < n; i++) {
                //打印空格
                for (int j = 0; j < n - i - 1; j++) {
                    System.out.print(" ");
                }
                //打印 * +“  ”+ *
                for (int j = 0; j < 2 * i + 1; j++) {
                    if(j == 0||j == 2 * i ||i == n-1)  //第一和倒数第一打印*,最后一行全部是*
                        System.out.print("*");
                    else    //中间部分
                        System.out.print(" ");
                }
//                if(i == 0){   //开头
//                    System.out.print("*");
//                }else if(i != n-1){   //中间
//                    System.out.print("*");
//                    for (int j = 0; j < 2 * i - 1; j++) {
//                        System.out.print(" ");
//                    }
//                    System.out.print("*");
//                }else{    //尾部
//                    for (int j = 0; j < 2 * i + 1; j++) {
//                        System.out.print("*");
//                    }
//                }
                //换行
                System.out.println();
            }
        }
    }
}
