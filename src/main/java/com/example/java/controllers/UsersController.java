package com.example.java.controllers;

import com.example.java.ResponsEntity;
import com.example.java.UserEntity;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.*;

@RestController
public class UsersController {

    private Map<String, UserEntity> userEntityMap = new HashMap<>();

    public UsersController() {
        //userEntityMap.put(1 , new UserEntity( "Ala", 20));
       // userEntityMap.put(2 , new UserEntity( "Ala2", 22));
    }

    @RequestMapping("/api/users")
    @ResponseBody
    public ResponsEntity users (@RequestParam(name= "page-number") @Min(1)Integer pageNumber,
                                @RequestParam(name= "page-size")@Min(1)@Max(100)Integer pageSize)
    {
        Integer totalCount = userEntityMap.size();
        Integer pagesCount = (int)Math.ceil(totalCount/(double)pageSize);
        Integer startNumber = pageSize*(pageNumber-1);
        Integer metaNumber = pageSize*pageNumber;
        if (metaNumber > totalCount ){
            metaNumber = totalCount;
        }
        List<UserEntity> list = new ArrayList<UserEntity>(userEntityMap.values());
        List<UserEntity> resultUsers = list.subList(startNumber, metaNumber);
        return new ResponsEntity ( resultUsers,pageNumber,pagesCount,pageSize,totalCount);


    }

    @RequestMapping(value ="/api/users/{id}" ,
            method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable String id) {
        return userEntityMap.get(id);

    }

    @RequestMapping(value="/api/users/{id}/remove",
    method = RequestMethod.DELETE)
    @ResponseBody
    public String removeUser(@PathVariable String id) {
        userEntityMap.remove(id);
        return "{\"result\": true}";
    }


    @RequestMapping(
            value = "/api/user/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public UserEntity createUser(@RequestBody UserEntity user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        userEntityMap.put(id,user);

        return user;
    }
    @RequestMapping(
            value = "/api/users/{id}/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserEntity updateUser(@PathVariable String id, @RequestBody UserEntity body){
       UserEntity user = userEntityMap.get(id);

       user.setEmail(body.getEmail());
       user.setName(body.getName());
       return user;
    }

}
