package pl.julka99.customerservice.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.julka99.customerservice.api.json.UserCreateJson;
import pl.julka99.customerservice.api.json.UserJson;
import pl.julka99.customerservice.data.table.UserRecord;
import pl.julka99.customerservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/registration")
    public ResponseEntity<Void> createUser(@RequestBody UserCreateJson userCreateJson) {
        userService.createUser(userCreateJson);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();

    }
    @GetMapping("/by-email")
    public ResponseEntity<UserJson> getUserByEmail(@RequestParam("email") String email){
        UserJson userJson= userService.getByEmail(email);
        return  ResponseEntity.status(HttpStatus.OK)
        .body(userJson);

    }
    @GetMapping("/by-id")
    public ResponseEntity<UserJson> getUserId(@RequestParam("id")Integer id){
        UserJson userJson =userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(userJson);

    }
}
