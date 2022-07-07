package pl.julka99.libraryservice.api.json;

import java.util.Date;

public class BookWithRentJson {
    private Date from;
    private Date to;
    private BookJson bookJson;

    public BookWithRentJson() {
    }

    public BookWithRentJson(Date from, Date to, BookJson bookJson) {
        this.from = from;
        this.to = to;
        this.bookJson = bookJson;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public BookJson getBookJson() {
        return bookJson;
    }

    public void setBookJson(BookJson bookJson) {
        this.bookJson = bookJson;
    }
}