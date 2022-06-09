package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.julka99.libraryservice.api.json.RegistrationJson;

@RestController()
@RequestMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)

public class RegistrationController {
    public ResponseEntity<Void> registration(@RequestBody RegistrationJson registrationJson){
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

}
