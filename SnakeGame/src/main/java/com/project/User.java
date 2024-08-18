package com.project;

public class User {

    private String user_Id;
    private String userName;
    private int score;
    private String contact;

    public User() {
    }

    public User(String userName,String contact) {
        this.userName = userName;
        this.score = 0;
        this.contact = contact;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_Id='" + user_Id + '\'' +
                ", userName='" + userName + '\'' +
                ", score=" + score +
                ", contact='" + contact + '\'' +
                '}';
    }
}
