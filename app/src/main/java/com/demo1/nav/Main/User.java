package com.demo1.nav.Main;

public class User {
    private String username;
    private String email;
    private String oran;
    private String password;



    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOran() {
        return oran;
    }

    public void setOran(String oran) {
        this.oran = oran;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    public User(String email,String username,String password,String oran){
        this.email=email;
        this.setPassword(password);
        this.username=username;
        this.oran=oran;


    }
}
