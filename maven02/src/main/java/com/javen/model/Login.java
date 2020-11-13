package com.javen.model;

public class Login {
    private Integer id;

    private String user_name;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString(){
    	return "[\""+id+"\",\""+user_name+"\",\""+password+"\"]";
    }
}