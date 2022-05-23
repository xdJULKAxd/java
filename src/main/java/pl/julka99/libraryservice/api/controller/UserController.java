package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.julka99.libraryservice.api.json.StatusJson;


@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {

    @GetMapping("/user/status")
    public ResponseEntity<StatusJson> userStatus() {

        return ResponseEntity.status(HttpStatus.OK)

                .build();

    }

}


