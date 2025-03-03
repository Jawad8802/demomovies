package com.example.demomovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.demomovies.adapter.MovieAdapter;
import com.example.demomovies.data.ApiClient;
import com.example.demomovies.data.ApiService;
import com.example.demomovies.model.MovieResponse;
import com.example.demomovies.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private static final String API_KEY = "99e3b7c68c146700906f0a70133ba340";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        apiService.getPopularMovies(API_KEY).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getMovies();
                    movieAdapter = new MovieAdapter(MainActivity.this, movies);
                    recyclerView.setAdapter(movieAdapter);
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
                Toast.makeText(MainActivity.this, "Failed to fetch movies", Toast.LENGTH_SHORT).show();
            }
        });
    }
}