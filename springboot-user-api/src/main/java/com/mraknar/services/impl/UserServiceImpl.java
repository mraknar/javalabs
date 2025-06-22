package com.mraknar.services.impl;

import com.mraknar.entities.User;
import com.mraknar.repository.UserRepository;
import com.mraknar.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id){
        Optional<User> optional = userRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteUserById(Integer id) {
        User user = getUserById(id);
        if(user != null){
            userRepository.deleteById(id);
        }
    }

    @Override
    public User updateUser(Integer id, User updatedUser){
        User existingUser  = userRepository.findById(id).orElse(null);

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setDateOfBirth(updatedUser.getDateOfBirth());

        return userRepository.save(existingUser);

    }

}
