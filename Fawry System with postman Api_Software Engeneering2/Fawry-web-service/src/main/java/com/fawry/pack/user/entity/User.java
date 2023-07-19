package com.fawry.pack.user.entity;

public abstract class User {
    protected String userName, password, email;
    protected static int id = 1;
    protected int userId;

    public int getUserId() {
        return userId;
    }

    public User() {
        this.userId = User.id;
        User.id++;
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userId = User.id;
        User.id++;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
     
        {
            "userName":"",
            ""
        }
    
    
    
     */

}
