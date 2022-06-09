package pl.julka99.customerservice.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.julka99.customerservice.api.json.UserCreateJson;

@RestController("/users")
@RequestMapping
public class UserController {
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserCreateJson userCreateJson){
        return  ResponseEntity.status(HttpStatus.CREATED)
                .build();

    }

    public ResponseEntity<Void> deleteUser(@PathVariable ("id")Integer id){

    }
}
