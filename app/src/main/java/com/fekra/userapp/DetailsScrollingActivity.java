package com.fekra.userapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsScrollingActivity extends AppCompatActivity {

    ImageView ivPhoto;
    TextView placeName, details, hours, offers;
    RecyclerView rv_photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Book a reservation or see the map ??", Snackbar.LENGTH_LONG)
                        .setAction("reserve", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // add the reservation to your Api
                            }
                        }).setAction("Map", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //intent to the map Activity
                        startActivity(new Intent(DetailsScrollingActivity.this, MapActivity.class));
                    }
                }).show();
            }
        });

        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("arrayListPhotosBundle");

        ArrayList<String> photosList = bundle.getStringArrayList("photosList");

        ivPhoto = findViewById(R.id.expandedImage);
        Picasso.get().load(photosList.get(0)).into(ivPhoto);


        placeName = findViewById(R.id.tv_place_name);
        details = findViewById(R.id.tv_description);
        offers = findViewById(R.id.tv_offers);
        hours = findViewById(R.id.tv_hours);

        //get the data from the api and place them in the text views

        rv_photos.setAdapter(new DetailsPhotosRecyclerAdapter(DetailsScrollingActivity.this, photosList));
        rv_photos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));

    }
}
