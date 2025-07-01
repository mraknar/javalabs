package com.mraknar.library.controller;

import com.mraknar.library.dto.user.UserRequestDTO;
import com.mraknar.library.dto.user.UserResponseDTO;
import com.mraknar.library.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.createUser(userRequestDTO);
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
