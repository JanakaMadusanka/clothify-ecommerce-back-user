package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final UserService service;
    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        service.addUser(user);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        if(service.updateUser(user)){
            return "Updated";
        }
        return "User doesn't exist";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (service.deleteUser(id)) {
            return "Deleted";
        }
        return "User doesn't exist";
    }

    @GetMapping("/get/all")
    public List<User> getAllUser(){
        return service.getAllUser();
    }

    @GetMapping("/search-by-id/{id}")
    public User searchUserById(@PathVariable Long id){
        return service.searchUserById(id);
    }

    @GetMapping("/search-by-name/{name}")
    public User searchUserByName(@PathVariable String name){
        return service.searchUserByName(name);
    }
}
