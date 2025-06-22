package com.mraknar.controller.impl;

import com.mraknar.controller.IUserController;
import com.mraknar.entities.User;
import com.mraknar.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class UserControllerImpl implements IUserController {

    private final IUserService userService;

    @Autowired
    public UserControllerImpl(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    @Override
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users")
    @Override
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @Override
    public User getUserById(@PathVariable(name = "id") Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteUserById(@PathVariable(name = "id") Integer id){
        userService.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public User updateUser(@PathVariable(name = "id") Integer id, @RequestBody User updatedUser){
        return userService.updateUser(id, updatedUser);
    }
}
