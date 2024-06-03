package com.example.apilogintest.ForgotPass;

import com.google.gson.annotations.SerializedName;

public class ForgotRequest {
    @SerializedName("email")
    private String email;

    public ForgotRequest (String email) {
        this.email = email;
    }
}
