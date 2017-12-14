package com.dev.felipe.movieflix.Retrofit.Discovery;

import com.dev.felipe.movieflix.Retrofit.Search.SearchResult;

public class MoviesAndTV {
    // this class is used to combine the results from both discovery queries at the same time

    public SearchResult mTvResult;
    public SearchResult mMovieResult;

    public MoviesAndTV(SearchResult movieResult, SearchResult tvResult) {
        mTvResult = tvResult;
        mMovieResult = movieResult;
    }
}
