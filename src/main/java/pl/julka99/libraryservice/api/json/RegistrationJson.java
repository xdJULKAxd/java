package pl.julka99.libraryservice.api.json;

public class RegistrationJson {
    private String name;
    private String email;
    private String password;

    public RegistrationJson() {
    }

    public RegistrationJson(String name, String email, String password) {
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
}
