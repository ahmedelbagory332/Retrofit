package com.example.bego.retrofit;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("comments")
    Call<List<Post>> getpost(@Query("postId") String postId , @Query("id") String id);

//    @POST("posts")
//    Call<Post> sotrepost(@Body Post post);

    @POST("posts")
    Call<Post> sotrepost(@Body HashMap<Object , Object> map);
}
