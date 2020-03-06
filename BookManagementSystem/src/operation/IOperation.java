package operation;

import book.BookList;

public interface IOperation {
    public void work(BookList bookList);
    public static int findBook(BookList bookList, String str){
        for (int i = 0; i < bookList.size; i++) {
            if(bookList.books[i].bookname.equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
