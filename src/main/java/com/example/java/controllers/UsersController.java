package com.example.java.controllers;

import com.example.java.UserEntity;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UsersController {

    private Map<Integer, UserEntity> userEntityMap = new HashMap<>();

    public UsersController() {
        userEntityMap.put(1 , new UserEntity(1, "Ala", 20));
        userEntityMap.put(2 , new UserEntity(2, "Ala2", 22));
    }

    @RequestMapping("/users")
    public Collection<UserEntity> users () {
        return userEntityMap.values();
    }

    @RequestMapping("/users/{id}/get")
    public UserEntity getUser(@PathVariable Integer id) {
        return userEntityMap.get(id);
    }

    @RequestMapping("/users/{id}/remove")
    public void removeUser(@PathVariable Integer id) {
        userEntityMap.remove(id);
    }

    @RequestMapping("/user/add")
    public UserEntity addUser(@RequestParam String name,
                           @RequestParam Integer age) {
        int id = new Random().nextInt(1000);
        while(userEntityMap.containsKey(id)) {
            id = new Random().nextInt(1000);
        }

        UserEntity user = new UserEntity(id, name, age);

        userEntityMap.put(id ,user);
        return user;
    }
}
