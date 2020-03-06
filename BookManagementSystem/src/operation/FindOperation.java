package operation;

import book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        System.out.println("请输入书籍名字：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.next();
        int n = IOperation.findBook(bookList,bookname);
        if(n != -1){
            System.out.println("为你找到书籍信息："+bookList.books[n]);
        }
        else {
            System.out.println("对不起，没有你要找的图书");
        }
    }
}
