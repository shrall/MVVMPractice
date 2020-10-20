package com.example.mvvmpractice.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmpractice.model.Cast;
import com.example.mvvmpractice.model.CastResponse;
import com.example.mvvmpractice.model.DetailResponse;
import com.example.mvvmpractice.model.Genre;
import com.example.mvvmpractice.model.Movie;
import com.example.mvvmpractice.model.MovieResponse;
import com.example.mvvmpractice.network.ApiEndpoints;
import com.example.mvvmpractice.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.Constants;

import static android.content.ContentValues.TAG;

public class MovieRepository {
    private static MovieRepository movieRepository;
    private static final String TAG = "MovieRepository";
    private RetrofitService service;

    private MovieRepository(){
        service = RetrofitService.getInstance();
    }

    public static MovieRepository getInstance(){
        if(movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public MutableLiveData<List<Movie>> getMovieCollection(){
        MutableLiveData<List<Movie>> listMovie = new MutableLiveData<>();
        service.getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        listMovie.postValue(response.body().getResults());
                    }
                }
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listMovie;
    }
    public MutableLiveData<String> getHomepage(int id) {
        MutableLiveData<String> homepage = new MutableLiveData<>();
        service.getDetails(Constants.Type.MOVIES, id).enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        homepage.postValue(response.body().getHomepage());
                    }
                }
            }
            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return homepage;
    }
    public MutableLiveData<String> getRuntime(int id) {
        MutableLiveData<String> runtime = new MutableLiveData<>();
        service.getDetails(Constants.Type.MOVIES, id).enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        runtime.postValue(response.body().getRuntime());
                    }
                }
            }
            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return runtime;
    }
    public MutableLiveData<List<Genre>> getGenres(int id) {
        MutableLiveData<List<Genre>> listGenres = new MutableLiveData<>();
        service.getDetails(Constants.Type.MOVIES, id).enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        listGenres.postValue(response.body().getGenres());
                    }
                }
            }
            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listGenres;
    }
    public MutableLiveData<List<Cast>> getCasts(int id) {
        MutableLiveData<List<Cast>> listCasts = new MutableLiveData<>();
        service.getCasts(Constants.Type.MOVIES, id).enqueue(new Callback<CastResponse>() {
            @Override
            public void onResponse(Call<CastResponse> call, Response<CastResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        listCasts.postValue(response.body().getCast());
                    }
                }
            }
            @Override
            public void onFailure(Call<CastResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listCasts;
    }
}
