//package com.example.demomovies.model;
//import com.google.gson.annotations.SerializedName;
//
//public class Movie {
//    @SerializedName("id")
//    private int id;
//
//    @SerializedName("title")
//    private String title;
//
//    @SerializedName("poster_path")
//    private String posterPath;
//
//    @SerializedName("release_date")
//    private String releaseDate;
//
//    @SerializedName("overview")
//    private String overview;
//
//    @SerializedName("vote_average")
//    private double rating;
//
//    public int getId() { return id; }
//    public String getTitle() { return title; }
//    public String getPosterPath() { return "https://image.tmdb.org/t/p/w500" + posterPath; }
//    public String getReleaseDate() { return releaseDate; }
//    public String getOverview() { return overview; }
//    public double getRating() { return rating; }
//}


package com.example.demomovies.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;  // Required for Serialization

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("overview")
    private String overview;

    @SerializedName("vote_average")
    private double rating;

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getPosterPath() { return "https://image.tmdb.org/t/p/w500" + posterPath; }
    public String getReleaseDate() { return releaseDate; }
    public String getOverview() { return overview; }
    public double getRating() { return rating; }
}
