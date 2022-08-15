package 第2部分._12集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 挚爱之夕
 * @date 2021/11/20 - 11 - 20 - 17:19
 * @Description 第2部分._12集合
 * @Version 1.0
 */
public class _3迭代器 {
    public static void main(String[] args) {
        Collection<Book> collection = new ArrayList<>();
        collection.add(new Book("红楼梦", "曹雪芹"));
        collection.add(new Book("三国演义", "罗贯中"));
        //迭代器
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //增强for循环,隐含了迭代器
        System.out.println("-------------------------");
        for (Object o:collection
             ) {
            System.out.println(o);
        }
    }
}
class Book{
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
