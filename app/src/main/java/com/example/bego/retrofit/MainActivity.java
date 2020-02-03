package com.example.bego.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Post post = new Post( "7122", "Fci" , "i am an android developer");

        HashMap<Object , Object> map = new HashMap<>();
        map.put("title","FCI ZU");
        map.put("body","my name is ahmed");
        map.put("userId",100);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Post> call = apiInterface.sotrepost(map);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {


                Log.d(TAG, "bigo onResponse: " + response.body().getBody());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

//        Call<List<Post>> call = apiInterface.getpost("1","2");
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//                     List<Post> posts = response.body();
//                for (int i = 0; i < posts.size(); i++) {
//
//                    Log.d(TAG, "bigo onResponse: " + response.body().get(i).getEmail());
//
//                }
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//
//                Log.d(TAG, "bigo onFailure: " + t.getMessage());
//
//            }
//        });

    }
}
