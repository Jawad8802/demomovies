package com.example.demomovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demomovies.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView moviePoster;
    private TextView movieTitle, movieOverview, movieReleaseDate, movieRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        moviePoster = findViewById(R.id.movieDetailPoster);
        movieTitle = findViewById(R.id.movieDetailTitle);
        movieOverview = findViewById(R.id.movieDetailOverview);
        movieReleaseDate = findViewById(R.id.movieDetailReleaseDate);
        movieRating = findViewById(R.id.movieDetailRating);

        // Get the selected movie object
        Movie movie = (Movie) getIntent().getSerializableExtra("movie");

        if (movie != null) {
            movieTitle.setText(movie.getTitle());
            movieOverview.setText(movie.getOverview());
            movieReleaseDate.setText("Release Date: " + movie.getReleaseDate());
            movieRating.setText("Rating: " + movie.getRating());

            Glide.with(this).load(movie.getPosterPath()).into(moviePoster);
        }
    }
}