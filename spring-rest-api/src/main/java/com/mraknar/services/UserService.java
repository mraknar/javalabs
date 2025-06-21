package com.mraknar.services;

import com.mraknar.model.User;
import com.mraknar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public List<User> getUserByParam(String firstName, String lastName) {
        return userRepository.getUserByParam(firstName, lastName);
    }

    public User createUser(User user){
        return userRepository.createUser(user);
    }

    public boolean deleteUserById(int id){
        return userRepository.deleteUserById(id);
    }

    public User updateUser(int id, User user){
        return userRepository.updateUser(id, user);
    }
}
