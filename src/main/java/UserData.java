import java.util.ArrayList;
import java.util.List;

public class UserData {
    List<User>  users = new ArrayList<>();
    User user1 = new User("Julia", "abc");
    User user2 = new User("Jack", "123");
    User user3 = new User("Buba", "123");
    public UserData() {
        users.add(user1);
        users.add(user2);
        users.add(user3);

    }
    public List<User> getUsers(){
        return this.users;
    }
    public boolean findUser(String name, String password){
        List<User> users = new UserData().getUsers();
        for(int i = 0; i<users.size(); i++){
            if(name.equals(users.get(i).getName()) && password.equals(users.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

}
