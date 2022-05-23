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
}
