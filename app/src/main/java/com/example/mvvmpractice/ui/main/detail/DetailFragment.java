package com.example.mvvmpractice.ui.main.detail;

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
import com.example.mvvmpractice.ui.splash.SplashFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment {

    @BindView(R.id.btnToMovieDetail)
    Button button;
    public DetailFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        button.setOnClickListener(v -> {
            NavDirections action  = DetailFragmentDirections.actionDetailToMovie();
            Navigation.findNavController(view).navigate(action);
        });
    }
}