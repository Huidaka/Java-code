package operation;

import book.BookList;

import java.util.Scanner;

public class DeleteOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        System.out.println("请输入书籍名字：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.next();
        int n = IOperation.findBook(bookList,bookname);
        if(n != -1){
            bookList.books[n] = null;
            for (int i = n; i < bookList.size-1; i++) {
                bookList.books[i] = bookList.books[i+1];
            }
            bookList.size--;
        }
        else {
            System.out.println("对不起，没有你要删除的图书");
        }
        System.out.println("您已经成功删除该图书");
    }
}
