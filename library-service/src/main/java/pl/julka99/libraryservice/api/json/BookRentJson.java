package pl.julka99.libraryservice.api.json;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class BookRentJson {

    private  Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date from;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date to;

    public BookRentJson() {
    }

    public BookRentJson(Integer id, Date from, Date to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }

    public Integer getId() {
        return id;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
