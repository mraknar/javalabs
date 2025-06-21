package com.mraknar.controller;

import com.mraknar.model.User;
import com.mraknar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestUserController {

    private final UserService userService;

    @Autowired
    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(name = "id", required = true) int id){
        return userService.getUserById(id);
    }

    @GetMapping("/users-param")
    public List<User> getUserByParam(@RequestParam(name = "firstName") String firstName,
                                        @RequestParam(name = "lastName", required = false) String lastName){
        return userService.getUserByParam(firstName, lastName);
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/delete-user/{id}")
    public boolean deleteUserById(@PathVariable(name = "id") int id){
        return userService.deleteUserById(id);
    }

    @PutMapping("/update-user/{id}")
    public User updateUser(@PathVariable(name = "id") int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
}
