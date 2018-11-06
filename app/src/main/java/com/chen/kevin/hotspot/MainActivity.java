package com.chen.kevin.hotspot;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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

        getMovie();
    }

    private void getMovie() {
        //http://gank.io/

        String baseUrl = "http://gank.io/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiServer movieService = retrofit.create(ApiServer.class);
        Call<Bean> call = movieService.getTopMovie(10, 1);

        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(@NonNull Call<Bean> call, @NonNull Response<Bean> response) {
                Log.d(TAG, "onResponse: " + response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<Bean> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }


        });
    }
}
