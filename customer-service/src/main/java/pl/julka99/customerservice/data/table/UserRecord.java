package pl.julka99.customerservice.data.table;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
        private  Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name="admin")
    private boolean admin;



    public UserRecord(Integer id, String name, String email, String password,Boolean admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;

    }

    public UserRecord() {
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
    public Boolean getAdmin(){
        return admin;
    }

    public String getPassword() {
        return password;
    }
}
