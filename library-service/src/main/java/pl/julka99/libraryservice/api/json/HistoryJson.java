package pl.julka99.libraryservice.api.json;

public class HistoryJson {
    private Integer id;
    private String from;
    private String to;
    private String name;

    public HistoryJson() {
    }

    public HistoryJson(Integer id, String from, String to, String name) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
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

    public void setTo(String to) {
        this.to = to;
    }

    public void setName(String name) {
        this.name = name;
    }
}
