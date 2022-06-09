package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)

public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestHeader("email") String email,
                                      @RequestHeader("password") String password){
        System.out.println(email);
        System.out.println(password);
        return ResponseEntity.status(HttpStatus.OK)

                .build();

    }

}
