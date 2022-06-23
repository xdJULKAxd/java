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
import pl.julka99.libraryservice.service.BookService;

@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookRentController
{
    private final BookService bookService;
    public BookRentController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/book/rent")
    public ResponseEntity<String> rentBook(@RequestBody BookRentJson bookRentJson) {

        String msg = bookService.rentBook(bookRentJson,1);


        return ResponseEntity.status(HttpStatus.OK)
                .body(msg);

    }

}
