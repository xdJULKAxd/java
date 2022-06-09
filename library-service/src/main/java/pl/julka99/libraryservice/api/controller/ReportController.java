package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {
    @PostMapping("/report")
    public ResponseEntity<Void> createReport(@RequestParam("from") String from,
                                      @RequestParam("to") String to){
        System.out.println(from);
        System.out.println(to);
        return ResponseEntity.status(HttpStatus.OK)

                .build();

    }
}
