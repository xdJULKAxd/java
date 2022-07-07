package pl.julka99.reportsservice.data.table;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class ReportRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "token")
    private String token;

    @Column(name = "content")
    private String content;

    public ReportRecord(Integer id, Integer userId, String name, String status,
                        String token, String content) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.status = status;
        this.token = token;
        this.content = content;
    }

    public ReportRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}