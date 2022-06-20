package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.julka99.libraryservice.api.json.BookCreateJson;
import pl.julka99.libraryservice.api.json.BookJson;
import pl.julka99.libraryservice.api.json.BookRentJson;

@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookRentController {
    @PostMapping("/book/rent")
    public ResponseEntity<Void> rentBook(@RequestBody BookRentJson bookRentJson) {
        //BookJson bookJson = bookService.createBook(bookCreateJson);

        //return ResponseEntity.status(HttpStatus.CREATED)
                //.body(bookJson);

    }
}
