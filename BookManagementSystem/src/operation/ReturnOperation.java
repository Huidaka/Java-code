package operation;

import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        System.out.println("请输入书籍名字：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.next();
        int n = IOperation.findBook(bookList,bookname);
        if(n != -1){
            if(bookList.books[n].status == "已借出"){
                System.out.println("恭喜你，已经成功归还："+bookname);
                bookList.books[n].status = "未借出";
            }
            else{
                System.out.println("对不起，该书还没有被借出");
            }
        }
        else {
            System.out.println("对不起，该书不属于本系统");
        }
    }
}
