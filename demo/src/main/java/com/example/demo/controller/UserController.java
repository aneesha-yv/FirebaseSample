package com.example.demo.controller;

import com.example.demo.object.Person;
import com.example.demo.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

    @Autowired
    FirebaseService firebaseService;
    @GetMapping("/getUserDetails")
    public Person getExample(@RequestHeader() String name) throws ExecutionException, InterruptedException {
        return firebaseService.getUserDetails(name);
    }
    @PostMapping("/createUser")
    public String createNewUser(@RequestBody Person person) throws ExecutionException, InterruptedException {
        return firebaseService.saveUserDetails(person);
    }
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody Person person) throws ExecutionException, InterruptedException {
        return firebaseService.updateUserDetails(person);
    }
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestHeader String name)
    {
        return firebaseService.deleteUser(name);
    }
}
