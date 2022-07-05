package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.julka99.libraryservice.api.json.UserJson;
import pl.julka99.libraryservice.client.CustomerServiceClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)

public class LoginController {
    private CustomerServiceClient customerServiceClient;

    public LoginController(CustomerServiceClient customerServiceClient) {
        this.customerServiceClient = customerServiceClient;

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestHeader("email") String email,
                                        @RequestHeader("password") String password,
                                        HttpServletRequest request) {
        UserJson userJson = customerServiceClient.getUserByEmail(email)
                ;
        if (userJson == null || !userJson.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("nie poprawne dane logowania");
        }
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("userId",userJson.getId());
        httpSession.setAttribute("admin",userJson.getAdmin());

        return ResponseEntity.status(HttpStatus.OK)
                .body("zalogowano");
    }

    @DeleteMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) throws ServletException {
        if(request.getSession() != null ){
            request.getSession().invalidate();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}