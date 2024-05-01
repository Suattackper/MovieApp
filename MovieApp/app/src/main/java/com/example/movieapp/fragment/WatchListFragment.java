package com.example.movieapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieapp.R;
import com.example.movieapp.adapter.MovieImageCategoryAdapter;
import com.example.movieapp.databinding.FragmentWatchListBinding;
import com.example.movieapp.model.MovieImageCategory;
import com.example.movieapp.model.MovieImageItem;

import java.util.ArrayList;
import java.util.List;


public class WatchListFragment extends Fragment {

    FragmentWatchListBinding binding;
    MovieImageCategoryAdapter movieImageCategoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentWatchListBinding.inflate(inflater, container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI();
    }

    private void initUI() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        movieImageCategoryAdapter = new MovieImageCategoryAdapter(getContext(), getMovieImageCategory());

        binding.rcvMovieList.setLayoutManager(manager);
        binding.rcvMovieList.setAdapter(movieImageCategoryAdapter);
    }

    private List<MovieImageCategory> getMovieImageCategory() {

        List<MovieImageCategory> movieImageCategoryList = new ArrayList<>();

        List<MovieImageItem> movieImageItemList = new ArrayList<>();

        movieImageItemList.add(new MovieImageItem(R.drawable.banner_one));
        movieImageItemList.add(new MovieImageItem(R.drawable.money_heist));
        movieImageItemList.add(new MovieImageItem(R.drawable.book));
        movieImageItemList.add(new MovieImageItem(R.drawable.mountain_forest_clouds));
        movieImageItemList.add(new MovieImageItem(R.drawable.mountain_winter));
        movieImageItemList.add(new MovieImageItem(R.drawable.money_heist));
        movieImageItemList.add(new MovieImageItem(R.drawable.banner_one));
        movieImageItemList.add(new MovieImageItem(R.drawable.book));
        movieImageItemList.add(new MovieImageItem(R.drawable.banner_one));

        movieImageCategoryList.add(new MovieImageCategory("Category One", movieImageItemList));
        movieImageCategoryList.add(new MovieImageCategory("Favorite TV Shows", movieImageItemList));
        movieImageCategoryList.add(new MovieImageCategory("Movies You're Like", movieImageItemList));

        return movieImageCategoryList;
    }
}