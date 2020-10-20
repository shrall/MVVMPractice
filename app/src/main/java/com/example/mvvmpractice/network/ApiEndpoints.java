package com.example.mvvmpractice.network;

import com.example.mvvmpractice.model.CastResponse;
import com.example.mvvmpractice.model.DetailResponse;
import com.example.mvvmpractice.model.MovieResponse;
import com.example.mvvmpractice.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoints {
    @GET("discover/movie")
    Call<MovieResponse> getMovies(@Query("api_key")String apiKey);

    @GET("discover/tv") // get tvShows data
    Call<TvShowResponse> getTvShows(@Query("api_key") String apiKey);

    @GET("{type}/{id}") // get details (if needed) and genres of specific movie / tv shows
    Call<DetailResponse> getDetails(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);

    @GET("{type}/{id}/credits") // get casts of specific movie / tv shows
    Call<CastResponse> getCasts(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);
}
