package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.julka99.libraryservice.api.json.BookCreateJson;
import pl.julka99.libraryservice.api.json.BookJson;

import java.util.List;

@RestController()
@RequestMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    @PostMapping("/books")
    public ResponseEntity<BookJson> createBook(@RequestBody BookCreateJson bookCreateJson) {
         String author=bookCreateJson.getAuthor();
        System.out.println(author);

        String title=bookCreateJson.getTitle();
        System.out.println(title);

        String description=bookCreateJson.getDescription();
        System.out.println(description);


         BookJson book = new BookJson(1, title, author, description);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(book);

    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
    @GetMapping("/books")
    public ResponseEntity<List<BookJson>> getBooks(){
        BookJson book = new BookJson(1, "title"," author"," description");
        BookJson book2 = new BookJson(2, "title2"," author2"," description2");

        return ResponseEntity.status(HttpStatus.OK)
                .body(List.of(book,book2));
    }

}
