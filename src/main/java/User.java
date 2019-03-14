public class User {
    private String username;
    private String password;
    public User(String u, String p){
        this.password = p;
        this.username= u;
    }
    public String getName(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}
