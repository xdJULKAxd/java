package pl.julka99.customerservice.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.julka99.customerservice.api.json.UserCreateJson;
import pl.julka99.customerservice.api.json.UserJson;
import pl.julka99.customerservice.service.UserService;

@RestController("/internal/users")
@RequestMapping
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserCreateJson userCreateJson) {
        userService.createUser(userCreateJson);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();

    }

    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();

    }
    public ResponseEntity<UserJson> getUserByEmail(@RequestParam("email") String email){

    }
}
