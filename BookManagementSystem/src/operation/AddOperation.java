package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书");
        System.out.println("请输入书籍的基本信息：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.next();
        String type = scanner.next();
        String author = scanner.next();
        double money = scanner.nextDouble();
        bookList.books[bookList.size] = new Book(bookname,type,author,money);
        bookList.size++;
        System.out.println("你已经成功添加该图书");
    }
}
