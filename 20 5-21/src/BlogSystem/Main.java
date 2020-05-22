package BlogSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BlogDemo blogDemo = new BlogDemo();
        while (true) {
            int n = Menu.menu1();
            if(n == 1) {
                if(blogDemo.login()) {
                    while (true) {
                        int m = Menu.menu2();
                        switch (m) {
                            case 0:
                                break;
                            case 1:
                                blogDemo.publishedArticles();
                                break;
                            case 2:
                                blogDemo.contentArticles();
                                break;
                            case 3:
                                blogDemo.likesArticles();
                                break;
                            case 4:
                                blogDemo.selectArticles();
                                break;
                            case 5:
                                blogDemo.selectLikes();
                                break;
                            case 6:
                                blogDemo.allArticle();
                                break;
                            default:
                                break;
                        }
                        if(m == 0){
                            break;
                        }
                    }
                }
            }
            else if(n == 2){
                blogDemo.register();
            }
            else if(n == 0){
                return;
            }
            else{
                System.out.println("输入有误");
            }
        }
    }
}
