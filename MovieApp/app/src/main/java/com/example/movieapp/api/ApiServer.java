package com.example.apilogintest;

import com.example.apilogintest.ForgotPass.ForgetResponse;
import com.example.apilogintest.ForgotPass.ForgotRequest;
import com.example.apilogintest.ResetPass.ResetPassResponse;
import com.example.apilogintest.ResetPass.ResetPassResquest;
import com.example.apilogintest.User.UserResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServer {
    public static final String BASE_URL = "http://10.0.2.2:3000/";

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiServer apiServer = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServer.class);


    @POST ("api/login") // Đường dẫn API đăng nhập
     Call<LoginResponse> login(@Body AccountRes accountRes);


@POST ("api/registered") // Đường dẫn API đăng nhập
Call<RegisResponse> register(@Body RegisterRes registerRes

);

    @GET("api/{id}")
    Call<UserResponse> getUser(@Path("id") String accountId,
                               @Header("Authorization") String authorization);
    @POST ("api/forgotpass") // Đường dẫn API đăng nhập
    Call<ForgetResponse> forgotPass(@Body ForgotRequest forgotRequest

    );


    //resetPass
    @POST("api/resetPass")
    Call<ResetPassResponse> resetPass(@Body ResetPassResquest resetPassRequest);


    /// gui email can email voi curent token

}
