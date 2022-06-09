package pl.julka99.libraryservice.service;

import org.springframework.stereotype.Service;
import pl.julka99.libraryservice.api.json.BookCreateJson;
import pl.julka99.libraryservice.api.json.BookJson;
import pl.julka99.libraryservice.data.repository.BookRepository;
import pl.julka99.libraryservice.data.table.BookRecord;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookJson createBook(BookCreateJson bookCreateJson) {
        BookRecord bookRecord = new BookRecord(null, bookCreateJson.getTitle(),
                bookCreateJson.getAuthor(), bookCreateJson.getDescription());
        bookRepository.save(bookRecord);
        bookRecord.getId();
        return new BookJson(bookRecord.getId(), bookRecord.getTitle(),
                bookRecord.getAuthor(), bookRecord.getDescription());

    }

    public void deleteBook(Integer id) {
        boolean existBook = bookRepository.existsById(id);
        if (existBook) {
            bookRepository.deleteById(id);
        }
    }
    public List<BookJson> getBooks(){
        List<BookRecord> books = bookRepository.findAll();

        List<BookJson> bookJsons = new ArrayList<>();

        for (BookRecord book : books) {
            BookJson bookJson = new BookJson(book.getId(),book.getTitle(),
                    book.getAuthor(),book.getDescription());
            bookJsons.add(bookJson);

        }
        return bookJsons;
    }
}
