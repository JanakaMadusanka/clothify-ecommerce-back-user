package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final UserService service;
    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        service.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (service.deleteUser(id)) {
            return "Deleted";
        }
        return "User doesn't exist";
    }
}
