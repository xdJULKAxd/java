package pl.julka99.customerservice.api.json;

public class UserJson {
    private  Integer id;
    private String name;
    private String email;
    private String password;
    private Boolean admin;

    public UserJson(Integer id, String name, String email, String password,Boolean admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public UserJson() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public Boolean getAdmin(){
        return admin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public  void setAdmin(Boolean admin){
        this.admin = admin;
    }
}
