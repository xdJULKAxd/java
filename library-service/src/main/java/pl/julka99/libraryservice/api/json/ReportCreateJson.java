package pl.julka99.libraryservice.api.json;

public class ReportCreateJson {
    private Integer userId;

    public ReportCreateJson(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}