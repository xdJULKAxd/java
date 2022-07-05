package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.julka99.libraryservice.api.json.BookCreateJson;
import pl.julka99.libraryservice.api.json.BookJson;
import pl.julka99.libraryservice.service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<BookJson> createBook(@RequestBody @Valid BookCreateJson bookCreateJson,
                                               HttpServletRequest request) {
        if (!SessionUtil.isAdmin(request)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
        BookJson bookJson = bookService.createBook(bookCreateJson);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookJson);

    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id,
                                           HttpServletRequest request) {
        if (!SessionUtil.isAdmin(request)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
        bookService.deleteBook(id)
        ;
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping("/books/all")
    public ResponseEntity<List<BookJson>> getAllBooks(HttpServletRequest request) {
        if (!SessionUtil.isAdmin(request)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
        List<BookJson> bookJsons = bookService.getBooks();
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookJsons);
    }

    @GetMapping("/books/available")
    public ResponseEntity<List<BookJson>> getAllAvailableBooks(@RequestParam("from") String from,
                                                               @RequestParam("to") String to,
                                                               HttpServletRequest request) {
        Integer userId = SessionUtil.getUserId(request);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
        List<BookJson> bookJsons = bookService.getAvailableBooks(from,to);
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookJsons);
    }

}