package com.fekra.userapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import Model.PlacesModel;

public class favouritesActivity extends AppCompatActivity {

    RecyclerView rvFav;
    List<PlacesModel> places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        rvFav = findViewById(R.id.rv_favourites);

        rvFav.setAdapter(new FavouritesRecyclerAdapter(favouritesActivity.this, places));
        rvFav.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


    }
}
