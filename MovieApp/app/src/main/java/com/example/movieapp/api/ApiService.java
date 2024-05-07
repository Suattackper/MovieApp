package com.example.movieapp.api;

import com.example.movieapp.model.MovieDetail;
import com.example.movieapp.model.MovieSearch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-đd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder()
        .baseUrl("https://phimapi.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiService.class);
//    @GET("phim/nguoi-sat")
//    Call<MovieDetail> getMovieDetail();
    @GET("phim/{slug}")
    Call<MovieDetail> getMovieBySlug(@Path("slug") String slug);
    // https://phimapi.com/v1/api/tim-kiem?keyword={Từ khóa}&limit={number}
    @GET("v1/api/tim-kiem")
    Call<MovieSearch> getMovieSearch(@Query("keyword") String keyword, @Query("limit") int limit);
}
