package pl.julka99.libraryservice.api.json;

public class ActualyJson {
    private Integer id;
    private String from;
    private String name;

    public ActualyJson() {
    }

    public ActualyJson(Integer id, String from, String name) {
        this.id = id;
        this.from = from;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setName(String name) {
        this.name = name;
    }
}
