import java.util.ArrayList;
import java.util.List;

public class UserManager {

    List<User> users;

    public List<Course> getAll(){
        return new ArrayList<Course>();
    }
    public void add(User user){
        System.out.println(user.getName() + " Kayıt Eklendi.");
    }
    public void delete(User user){
        System.out.println(user.getName() + " Kayıt Silindi.");
    }

    public void update(User user){
        System.out.println(user.getName() + " Kayıt Güncellendi.");
    }
}