package com.example.java;

public class UserEntity {
    private String id;
    private String name;
    private String email;

    public UserEntity( String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public void  setName(String name) {this.name =name;}
    public void  setEmail(String email) {this.email =email;}
}
