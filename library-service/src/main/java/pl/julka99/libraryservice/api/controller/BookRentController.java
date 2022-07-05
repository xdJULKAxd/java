package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.julka99.libraryservice.api.json.BookRentJson;
import pl.julka99.libraryservice.service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookRentController {
    private final BookService bookService;

    public BookRentController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/book/rent")
    public ResponseEntity<String> rentBook(@RequestBody @Valid BookRentJson bookRentJson,
                                           HttpServletRequest request) {
        Integer userId = SessionUtil.getUserId(request);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
        String msg = bookService.rentBook(bookRentJson,1);
        return ResponseEntity.status(HttpStatus.OK)
                .body(msg);

    }

}