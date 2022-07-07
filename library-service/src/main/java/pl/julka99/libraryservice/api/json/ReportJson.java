package pl.julka99.libraryservice.api.json;

public class ReportJson {
    private String userName;

    private String content;

    public ReportJson(String userName, String content) {
        this.userName = userName;
        this.content = content;
    }

    public ReportJson() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}