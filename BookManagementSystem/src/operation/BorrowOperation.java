package operation;

import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        System.out.println("请输入书籍名字：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.next();
        int n = IOperation.findBook(bookList,bookname);
        if(n != -1){
            if(bookList.books[n].status == "未借出"){
                System.out.println("恭喜你，已经成功借阅："+bookname);
                bookList.books[n].status = "已借出";
            }
            else{
                System.out.println("对不起，该书已经被借出");
            }
        }
        else {
            System.out.println("对不起，没有你要找的图书");
        }
    }
}
