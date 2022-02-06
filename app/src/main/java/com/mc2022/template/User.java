package com.mc2022.template;


import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String username;
    private List<Question> symptoms;

    public User(String username) {
        this.username = username;
        this.symptoms = new ArrayList<Question>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Question> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Question> symptoms) {
        this.symptoms = symptoms;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }
}
