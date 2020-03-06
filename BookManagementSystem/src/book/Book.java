package book;

import java.security.PublicKey;

public class Book {
    public String bookname;
    String type;
    String author;
    double money;
    public String status;

    public Book(String bookname, String author ,String type,double money) {
        this.bookname = bookname;
        this.type = type;
        this.author = author;
        this.money = money;
        status = "未借出";
    }

    @Override
    public String toString() {
        return "{" +
                "书名:《" + bookname + '》' +
                ", 类型:" + type +
                ", 作者:" + author +
                ", 价格:" + money +
                ",状态:"+status+
                '}';
    }
}
