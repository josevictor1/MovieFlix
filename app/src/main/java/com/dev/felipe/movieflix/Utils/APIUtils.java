package com.dev.felipe.movieflix.Utils;

import android.util.Log;

import com.dev.felipe.movieflix.UI.CardRecycleAdapter;
import com.dev.felipe.movieflix.Retrofit.RetrofitClient;
import com.dev.felipe.movieflix.Retrofit.Discovery.DiscoverInterface;
import com.dev.felipe.movieflix.Retrofit.Genres.Genre;
import com.dev.felipe.movieflix.Retrofit.Genres.GenreInterface;
import com.dev.felipe.movieflix.Retrofit.Genres.Genres;
import com.dev.felipe.movieflix.Retrofit.Search.SearchInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class APIUtils {

    public static final String BASE_URL = "https://api.themoviedb.org/";
    public static final String API_KEY = "625a7cbd9e0ae06da951620f6f0015d1";

    public static SearchInterface getSearchInterface() {
        return RetrofitClient.getClient(BASE_URL).create(SearchInterface.class);
    }

    public static DiscoverInterface getDiscoverInterface() {
        return RetrofitClient.getClient(BASE_URL).create(DiscoverInterface.class);
    }

    public static HashMap<String, Integer> genreIdMap() {
        final HashMap<String, Integer> result = new HashMap<String, Integer >();
        GenreInterface genreInterface = RetrofitClient.getClient(BASE_URL).create(GenreInterface.class);
        genreInterface.getGenres(API_KEY, "en-US").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Genres>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Genres genres) {
                        List<Genre> listOfGenres = genres.getGenres();
                        for (Genre genre: listOfGenres) {
                            result.put(genre.getName(), genre.getId());
                        }
                    }
                });
        return result;
    }

}
