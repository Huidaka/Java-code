package book;

public class BookList {
    public int size;
    public Book[] books = new Book[100];

    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", "小说",45.99);
        books[1] = new Book("西游记", "吴承恩", "小说",46.99);
        books[2] = new Book("水浒传", "施耐庵", "小说",47.99);
        books[3] = new Book("红楼梦", "曹雪芹", "小说",48.99);
        size = 4;
    }

}
