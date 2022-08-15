package 第2部分._11常用类._1Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 挚爱之夕
 * @date 2021/11/17 - 11 - 17 - 10:58
 * @Description 第2部分._11Array
 * @Version 1.0
 */
public class 练习 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅",90);
        books[2] = new Book("青年文摘",40);
        books[3] = new Book("java从入门到精通",50);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.name.length() - o2.name.length();
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return (int)(o1.price - o2.price);
            }
        });
        System.out.println(Arrays.toString(books));
    }
    static class Book{
        public Book(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String name;
        public double price;

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
