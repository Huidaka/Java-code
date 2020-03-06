package operation;

import book.BookList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DisplayOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("显示所有图书");
        for (int i = 0; i < bookList.size; i++) {
            System.out.println(i+1+"."+bookList.books[i]);
        }
    }
}
