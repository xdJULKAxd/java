package pl.julka99.customerservice.api.json;


import javax.validation.constraints.NotEmpty;

public class UserCreateJson {
    @NotEmpty(message = "Name cant be empty")
    private String name;
    @NotEmpty(message = "Email cant be empty")
    private String email;
    @NotEmpty(message = "Password cant be empty")
    private String password;

    public UserCreateJson() {
    }

    public UserCreateJson(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
