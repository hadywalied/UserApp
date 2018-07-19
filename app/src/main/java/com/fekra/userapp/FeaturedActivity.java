package com.fekra.userapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import Model.PlacesModel;

public class FeaturedActivity extends AppCompatActivity {

    RecyclerView rvFeatured;
    private List<PlacesModel> places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured);

        rvFeatured = findViewById(R.id.rv_featured);

        /*
         * add the list elements here
         *
         *
         * */


        FeaturedRecyclerAdapter featuredRecyclerAdapter = new FeaturedRecyclerAdapter(FeaturedActivity.this, places);


        rvFeatured.setAdapter(featuredRecyclerAdapter);
        rvFeatured.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


    }
}
