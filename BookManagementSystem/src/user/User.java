package user;

import book.BookList;
import operation.AddOperation;
import operation.IOperation;

import javax.sound.midi.Soundbank;

public abstract class User {
    String name;
    IOperation[] iOperations;
    public abstract int menu();

    public User(String name) {
        this.name = name;
    }

    public void doOperation(int n, BookList bookList){
        this.iOperations[n].work(bookList);
    }
}
