package com.mraknar.repository;

import com.mraknar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users;

    @Autowired
    public UserRepository(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers(){
        return users;
    }

    public User getUserById(int id){
        for (User user : users) {
            if  (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUserByParam(String firstName, String lastName) {
        List <User> userArrayList = new ArrayList<>();
        for (User user : users) {
            if (lastName != null) {
                if (user.getFirstName().equalsIgnoreCase(firstName) && user.getLastName().equalsIgnoreCase(lastName)) {
                    userArrayList.add(user);
                }
            }else{
                if (user.getFirstName().equalsIgnoreCase(firstName)) {
                    userArrayList.add(user);
                }
            }
        }
        return userArrayList;
    }

    public User createUser(User user){
        users.add(user);
        return user;
    }

    public boolean deleteUserById(int id){
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public User updateUser(int id, User user){
        for (User i : users) {
            if (i.getId() == id) {
                i.setFirstName(user.getFirstName());
                i.setLastName(user.getLastName());
                i.setUsername(user.getUsername());
                return i;
            }
        }
        return null;
    }
}
