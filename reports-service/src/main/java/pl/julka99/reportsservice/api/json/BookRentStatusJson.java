package pl.julka99.reportsservice.api.json;

import java.util.List;

public class BookRentStatusJson {
    private List<BookWithRentJson> bookRents;

    public BookRentStatusJson(List<BookWithRentJson> bookRents) {
        this.bookRents = bookRents;
    }

    public BookRentStatusJson() {
    }

    public List<BookWithRentJson> getBookRents() {
        return bookRents;
    }

    public void setBookRents(List<BookWithRentJson> bookRents) {
        this.bookRents = bookRents;
    }
}
