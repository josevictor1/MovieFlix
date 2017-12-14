package com.dev.felipe.movieflix.Retrofit.Genres;

import  com.dev.felipe.movieflix.Retrofit.Search.SearchResult;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface GenreInterface {
    @GET("/3/genre/movie/list")
    Observable<Genres> getGenres(@Query("api_key") String apiKey, @Query("language") String language);
}
