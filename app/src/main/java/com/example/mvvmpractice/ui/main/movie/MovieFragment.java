package com.example.mvvmpractice.ui.main.movie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mvvmpractice.R;
import com.example.mvvmpractice.model.Movie;
import com.example.mvvmpractice.ui.splash.SplashFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieFragment extends Fragment {
    @BindView(R.id.btnToDetail)
    Button button;
    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Movie movie = new Movie();


        button.setOnClickListener(v -> {
            NavDirections action  = MovieFragmentDirections.actionMovieToDetail(movie);
            Navigation.findNavController(view).navigate(action);
        });
    }
}