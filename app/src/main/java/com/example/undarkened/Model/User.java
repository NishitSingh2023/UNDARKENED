package com.example.undarkened.Model;

public class User {
    String username,email,imageURL,phoneno;

    public  User(){}

    public User(String username, String email, String imageURL,String phoneno) {
        this.username = username;
        this.email = email;
        this.imageURL = imageURL;
        this.phoneno=phoneno;

    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getImageURL() {
        return imageURL;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
