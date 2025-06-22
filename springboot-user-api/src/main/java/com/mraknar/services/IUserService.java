package com.mraknar.services;

import com.mraknar.entities.User;

import java.util.List;

public interface IUserService {

    public User createUser(User user);

    public List<User> getAllUsers();

    public User getUserById(Integer id);

    public void deleteUserById(Integer id);

    public User updateUser(Integer id, User updatedUser);
}
