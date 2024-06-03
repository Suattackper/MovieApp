package com.example.apilogintest.ResetPass;

import com.google.gson.annotations.SerializedName;

public class ResetPassResquest {
    @SerializedName("email")
    private String email;
    @SerializedName("resetCode")
    private int resetCode;

    public ResetPassResquest(String email, int resetCode) {
        this.email = email;
        this.resetCode = resetCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getResetCode() {
        return resetCode;
    }

    public void setResetCode(int resetCode) {
        this.resetCode = resetCode;
    }
}
