package 第2部分._12集合.作业;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 15:12
 * @Description 第2部分._12集合.作业
 * @Version 1.0
 */
public class _4ArrayList练习 {
    public static void main(String[] args) {
        Journalism news1 = new Journalism("新闻一");
        Journalism news2 = new Journalism("新闻二");
        news1.setContent("新冠确诊病例超千万，数百万印度教信徒赴恒河圣浴引民众担忧");
        news2.setContent("男子突然想起两个月前钓的鱼还在网里，捞起来一看赶紧放生");
        List<Journalism> list = new ArrayList<>();
        list.add(news1);
        list.add(news2);
        for (int i = list.size() - 1; i >= 0; i--) {
            Journalism news = list.get(i);
            if(news.getContent().length()>15){
                System.out.println(news.getContent().substring(0, 15) + "...");
            }else{
                System.out.println(news.getContent());
            }
        }
    }
}
class Journalism{
    private String title;
    private String content;

    public Journalism(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
