package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.julka99.libraryservice.api.json.BookCreateJson;
import pl.julka99.libraryservice.api.json.BookJson;
import pl.julka99.libraryservice.service.BookService;

import java.util.List;

@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<BookJson> createBook(@RequestBody BookCreateJson bookCreateJson) {
        BookJson bookJson = bookService.createBook(bookCreateJson);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookJson);

    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookJson>> getBooks() {
       List<BookJson> bookJsons = bookService.getBooks();
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookJsons);
    }


}
