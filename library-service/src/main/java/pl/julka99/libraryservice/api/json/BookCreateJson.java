package pl.julka99.libraryservice.api.json;

import javax.validation.constraints.NotEmpty;

public class BookCreateJson {
    @NotEmpty(message = "Title cant be empty")
    private String title;

    @NotEmpty(message = "Author cant be empty")
    private String author;

    @NotEmpty(message = "Description cant be empty")
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