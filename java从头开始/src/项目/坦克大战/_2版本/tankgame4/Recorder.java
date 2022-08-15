package 项目.坦克大战._2版本.tankgame4;

import java.io.*;
import java.util.Vector;

/**
 * @author 挚爱之夕
 * @date 2021/12/5 - 12 - 05 - 23:26
 * @Description 项目.坦克大战._2版本.tankgame3
 * @Version 1.0
 */
public class Recorder {
    //记录我方击毁坦克数量
    private static int defeatedTanks = 0;
    //数据保存路径
//    private static final String filePath = "E:/tankGame.txt";
    public static final String filePath = "src/tankGame.txt";
    //定义IO对象，写数据到文件
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    //记录坦克坐标和方向
    private static Vector<Enemy> enemies = null;
    //我方坦克
    private static Hero hero = null;
    //全体坦克
    private static Vector<Tank> tanks = null;
    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(defeatedTanks + "\r\n");
//            bw.newLine();
            //写入我方信息
            bw.write(hero.getX() + " " + hero.getY() + " " + hero.getDirection());
            bw.newLine();
            //写入敌方信息
            for (Enemy enemy:enemies
                 ) {
                bw.write(enemy.getX() + " " + enemy.getY() + " " + enemy.getDirection());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void readRecord(){
        try {
            br = new BufferedReader(new FileReader(filePath));
            String defeatedTanks = br.readLine();
            //存储信息
            enemies = new Vector<>();
            tanks = new Vector<>();
            //击败坦克数
            Recorder.defeatedTanks = Integer.parseInt(defeatedTanks);
            //我方坦克信息
            String[] heroInfo = br.readLine().split(" ");
            hero = new Hero(Integer.parseInt(heroInfo[0]), Integer.parseInt(heroInfo[1]));
            hero.setDirection(Integer.parseInt(heroInfo[2]));
            hero.setSpeed(5);
            tanks.add(hero);
            Enemy enemy = null;
            String line ;
            while((line = br.readLine()) != null){
                String[] enemyInfo = line.split(" ");
                int x = Integer.parseInt(enemyInfo[0]);
                int y = Integer.parseInt(enemyInfo[1]);
                int direction = Integer.parseInt(enemyInfo[2]);
                enemy = new Enemy(x, y);
                enemy.setDirection(direction);
                enemy.setTanks(tanks);
                enemies.add(enemy);
                new Thread(enemy).start();
                tanks.add(enemy);
            }
            hero.setTanks(tanks);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //每次击毁坦克调用该方法
    public static void addNumber(){
        defeatedTanks++;
    }
    public static int getDefeatedTanks() {
        return defeatedTanks;
    }

    public static void setDefeatedTanks(int defeatedTanks) {
        Recorder.defeatedTanks = defeatedTanks;
    }

    public static Vector<Enemy> getEnemies() {
        return enemies;
    }

    public static void setEnemies(Vector<Enemy> enemies) {
        Recorder.enemies = enemies;
    }

    public static Hero getHero() {
        return hero;
    }

    public static void setHero(Hero hero) {
        Recorder.hero = hero;
    }


    public static Vector<Tank> getTanks() {
        return tanks;
    }

    public static void setTanks(Vector<Tank> tanks) {
        Recorder.tanks = tanks;
    }

}
