package pl.julka99.libraryservice.data.table;

import javax.persistence.*;

@Table(name = "books")
@Entity()

public class BookRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "description")
    private String description;

    public BookRecord (Integer id,String title, String author,String description){
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;

    }

    public BookRecord() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
}
