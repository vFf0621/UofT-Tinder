package demo2;

import java.util.ArrayList;

public class Database {

    private ArrayList<User> users;
    private ArrayList<User> potential;


    public Database(){
        this.users = new ArrayList<>();
        this.potential = new ArrayList<>();
    }

    public void getPotentialUser(User user){
        String preference = user.getGenderPreference();
        for(User)
    }

    public User nextUser(){
        if(potential.size() == 0){
            return false;
        }
        potential.remove(0);
    }
}
