package BlogSystem;

public class User {
    private static int id;
    private static String username;
    private static String password;

    public  void setId(int id) {
        User.id = id;
    }

    public void setUsername(String username) {
        User.username = username;
    }

    public void setPassword(String password) {
        User.password = password;
    }

    public  int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public  String getPassword() {
        return password;
    }

}
