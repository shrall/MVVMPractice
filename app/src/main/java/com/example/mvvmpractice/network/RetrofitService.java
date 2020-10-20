package com.example.mvvmpractice.network;

import com.example.mvvmpractice.model.CastResponse;
import com.example.mvvmpractice.model.DetailResponse;
import com.example.mvvmpractice.model.MovieResponse;
import com.example.mvvmpractice.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import util.Constants;

public class RetrofitService {
    //    private static Retrofit retrofit;
//
//    public static <S> S createService(Class<S> serviceClass) {
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit.create(serviceClass);
//    }
    private ApiEndpoints api;
    private static RetrofitService service;

    private RetrofitService() {
        api = new Retrofit.Builder()
                .baseUrl(Constants.BaseSetting.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiEndpoints.class);
    }

    public static RetrofitService getInstance() {
        if (service == null) {
            service = new RetrofitService();
        }
        return service;
    }

    public Call<MovieResponse> getMovies() {
        return api.getMovies(Constants.BaseSetting.API_KEY);
    }

    public Call<TvShowResponse> getTvShows() {
        return api.getTvShows(Constants.BaseSetting.API_KEY);
    }

    public Call<DetailResponse> getDetails(String type, int id) {
        return api.getDetails(type, id, Constants.BaseSetting.API_KEY);
    }

    public Call<CastResponse> getCasts(String type, int id) {
        return api.getCasts(type, id, Constants.BaseSetting.API_KEY);
    }
}
