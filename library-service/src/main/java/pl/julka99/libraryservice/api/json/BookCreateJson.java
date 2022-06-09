package pl.julka99.libraryservice.api.json;

public class BookCreateJson {
    private String title;
    private String author;
    private String description;

    public BookCreateJson() {
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
