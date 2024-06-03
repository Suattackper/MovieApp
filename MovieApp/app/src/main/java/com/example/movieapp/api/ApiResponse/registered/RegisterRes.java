package com.example.apilogintest;
import com.google.gson.annotations.SerializedName;

public class RegisterRes {


        @SerializedName("email")
        private String username;
        @SerializedName("phone")
        private String phone;

        @SerializedName("password")
        private String password;

        // Constructor, getters, and setters


    public RegisterRes(String username, String phone, String password) {
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
