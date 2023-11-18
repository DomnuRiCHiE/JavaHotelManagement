package Domain.People;

import java.util.Objects;

public class Admin extends Person{

    private static Admin instance;

    public static Admin getInstance(){
        if (instance == null){
            instance = new Admin();
        }
        return instance;
    }

    private Admin() {
        super.setName("admin");
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean login(String username, String password) {
        if (!Objects.equals(username, this.name) || !Objects.equals(password, this.password)){
            System.out.println("Username or password not matching");
            return false;
        }
        return true;
    }
}
