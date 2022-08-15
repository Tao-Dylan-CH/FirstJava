package 项目.我的尝试;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/5 - 11 - 05 - 23:01
 * @Description 第1部分._3类与对象
 * @Version 1.0
 */
public class _1猜拳游戏 {
    public static void main(String[] args) {
        new Scanner(System.in);
        Tom tom = new Tom(3);
        for (int i = 0; i < 3; i++) {
            tom.computerGuess();
            tom.tomeGuess();
            String result = tom.tomVsComputer();
            tom.printHead();
            tom.printInformation(result);
        }
        tom.printResult();
    }
}

class Tom {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int[] tomGuessNum;
    int[] computerGuessNum;
    String[] resultOfMatch;
    int winCount = 0;
    int inning = 0;
    int numberOfMatches;

    public Tom(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
        tomGuessNum = new int[numberOfMatches];
        computerGuessNum = new int[numberOfMatches];
        resultOfMatch = new String[numberOfMatches];
    }

    void computerGuess() {
        this.computerGuessNum[inning] = random.nextInt(3);
    }

    void tomeGuess() {
        System.out.println("输入数字:0-剪刀   1-石头    2-布");
        int n = scanner.nextInt();
        if (n == 0 || n == 1 || n == 2) {
            tomGuessNum[inning] = n;
        } else {
            throw new IllegalArgumentException("输入数字非法！");
        }
    }

    String tomVsComputer() {
        if (tomGuessNum[inning] == 0 && computerGuessNum[inning] == 2) {
            winCount++;
            resultOfMatch[inning] = "你赢了";
            inning++;
            return "你赢了";
        } else if (tomGuessNum[inning] == 1 && computerGuessNum[inning] == 0) {
            winCount++;
            resultOfMatch[inning] = "你赢了";
            inning++;
            return "你赢了";
        } else if (tomGuessNum[inning] == 2 && computerGuessNum[inning] == 1) {
            winCount++;
            resultOfMatch[inning] = "你赢了";
            inning++;
            return "你赢了";
        } else if (tomGuessNum[inning] == computerGuessNum[inning]) {
            resultOfMatch[inning] = "平手";
            inning++;
            return "平手";
        } else {
            resultOfMatch[inning] = "你输了";
            inning++;
            return "你输了";
        }
    }

    void printInformation(String result) {
        System.out.println(inning + "\t" + computerGuessNum[inning - 1] + "\t\t" + tomGuessNum[inning - 1] + "\t\t" + result);
        System.out.println("---------------------------------------------");
    }

    void printHead() {
        System.out.println("---------------------------------------------");
        System.out.println("局数\t电脑出拳\t玩家出拳\t输赢情况");
    }

    void printResult() {
        System.out.println("比赛结束，战绩已生成。");
        System.out.println("局数\t电脑出拳\t玩家出拳\t输赢情况");
        for (int i = 0; i < numberOfMatches; i++) {
            System.out.println((i + 1) + "\t" + computerGuessNum[i] + "\t\t" + tomGuessNum[i] + "\t\t" + resultOfMatch[i]);
        }
        System.out.println("三场中你共赢了" + winCount + "场");
        if (winCount == 0) {
            System.out.println("真是只锦鲤！");
        }
        if (winCount == 1) {
            System.out.println("有点菜！");
        }
        if (winCount == 2) {
            System.out.println("还可以！");
        }
        if (winCount == 3) {
            System.out.println("干得漂亮！");
        }
    }
}
