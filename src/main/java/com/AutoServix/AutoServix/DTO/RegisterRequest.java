package com.AutoServix.AutoServix.DTO;

public class RegisterRequest {

    private String Name;

    public RegisterRequest(String email, String name, String password) {
        Email = email;
        Name = name;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String Email;
    private String password;

}
