package pl.julka99.libraryservice.service;

import org.springframework.stereotype.Service;
import pl.julka99.libraryservice.api.json.*;
import pl.julka99.libraryservice.data.repository.BookCustomerRepository;
import pl.julka99.libraryservice.data.repository.BookRepository;
import pl.julka99.libraryservice.data.table.BookCustomerRecord;
import pl.julka99.libraryservice.data.table.BookRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookCustomerRepository bookCustomerRepository;

    public BookService(BookRepository bookRepository, BookCustomerRepository bookCustomerRepository) {
        this.bookRepository = bookRepository;
        this.bookCustomerRepository = bookCustomerRepository;
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
        boolean existBook = bookRepository.existsById(id)
                ;
        if (existBook) {
            bookRepository.deleteById(id)
            ;
        }
    }

    public List<BookJson> getBooks() {
        List<BookRecord> books = bookRepository.findAll();

        List<BookJson> bookJsons = new ArrayList<>();

        for (BookRecord book : books) {
            BookJson bookJson = new BookJson(book.getId(), book.getTitle(),
                    book.getAuthor(), book.getDescription());
            bookJsons.add(bookJson);

        }
        return bookJsons;
    }

    public List<BookJson> getAvailableBooks(String from, String to) {
        Date fromDate = DateHelper.convertToDate(from);
        Date toDate = DateHelper.convertToDate(to);
        List<BookRecord> books = bookRepository.findAll();

        List<BookJson> bookJsons = new ArrayList<>();

        for (BookRecord book : books) {

            if (!bookCustomerRepository.existsByBookIdAndFromLessThanEqualAndToGreaterThanEqual(book.getId(),
                    toDate, fromDate)) {
                BookJson bookJson = new BookJson(book.getId(), book.getTitle(),
                        book.getAuthor(), book.getDescription());
                bookJsons.add(bookJson);


            }

        }
        return bookJsons;
    }

    public String rentBook(BookRentJson bookRentJson, Integer customerId) {
        if (!bookRepository.existsById(bookRentJson.getId())) {
            return "książka do wypozyczenia nie istnieje";
        }
        boolean alreadyExistRent = bookCustomerRepository.existsByBookIdAndFromLessThanEqualAndToGreaterThanEqual(bookRentJson.getId(),
                bookRentJson.getTo(), bookRentJson.getFrom());
        if (!alreadyExistRent) {
            BookCustomerRecord bookCustomerRecord = new BookCustomerRecord(null, customerId,
                    bookRentJson.getId(), bookRentJson.getFrom(), bookRentJson.getTo());
            bookCustomerRepository.save(bookCustomerRecord);
            return " książka wypożyczona";
        } else {
            return "istnieje wypożyczenei w tym czasie- wypożyczenie nie zrealizowane!";
        }

    }

    public BookRentStatusJson getBookRentStatusJson(Integer userId) {
        List<BookCustomerRecord> allByCustomerId = bookCustomerRepository.getAllByCustomerId(userId);
        List<BookWithRentJson> rents = new ArrayList<>();
        for (BookCustomerRecord bookCustomerRecord : allByCustomerId) {
            BookRecord bookRecord = bookRepository.findById(bookCustomerRecord.getBookId())
                    .orElse(null);
            if (bookRecord == null) {
                continue;
            }

            rents.add(new BookWithRentJson(bookCustomerRecord.getFrom(), bookCustomerRecord.getTo(),
                    new BookJson(bookRecord.getId(), bookRecord.getTitle(), bookRecord.getAuthor(),
                            bookRecord.getDescription())));
        }
        return new BookRentStatusJson(rents);
    }
}