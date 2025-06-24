package com.mraknar.controller.impl;

import com.mraknar.controller.IUserController;
import com.mraknar.dto.user.UserDto;
import com.mraknar.dto.user.UserDtoIU;
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
    public UserDto createUser(@RequestBody UserDtoIU user) {
        return userService.createUser(user);
    }

    @PostMapping("create/bulk")
    @Override
    public List<UserDto> createUsers(@RequestBody List<UserDtoIU> users){
        return userService.createUsers(users);
    }

    @GetMapping("/users")
    @Override
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @Override
    public UserDto getUserById(@PathVariable(name = "id") Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteUserById(@PathVariable(name = "id") Integer id){
        userService.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public UserDto updateUser(@PathVariable(name = "id") Integer id, @RequestBody UserDtoIU updatedUser){
        return userService.updateUser(id, updatedUser);
    }
}
