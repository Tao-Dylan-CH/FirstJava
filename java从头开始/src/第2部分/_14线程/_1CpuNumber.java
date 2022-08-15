package 第2部分._14线程;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 12:13
 * @Description 第2部分._14线程
 * @Version 1.0
 */
public class _1CpuNumber {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNumber = runtime.availableProcessors();
        System.out.println("CPU数：" + cpuNumber);
    }
}
