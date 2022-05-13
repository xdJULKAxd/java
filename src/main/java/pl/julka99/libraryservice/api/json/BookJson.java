package pl.julka99.libraryservice.api.json;

public class BookJson {
    private Integer id;
    private String title;
    private String author;
    private String description;

    public BookJson() {
    }

    public BookJson(Integer id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;

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
