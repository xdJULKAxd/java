package pl.julka99.libraryservice.data.table;

import javax.persistence.*;
import java.util.Date;

@Table(name = "books_customers")
@Entity()

public class BookCustomerRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "book_id")
    private Integer bookId;
    @Temporal(TemporalType.DATE)
    @Column(name = "from_date")
    private Date from;
    @Temporal(TemporalType.DATE)
    @Column(name = "to_date")
    private Date to;

    public BookCustomerRecord(Integer id, Integer customerId, Integer bookId, Date from, Date to) {
        this.id = id;
        this.customerId = customerId;
        this.bookId = bookId;
        this.from = from;
        this.to = to;
    }

    public BookCustomerRecord() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getBookId() {
        return bookId;
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

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}

