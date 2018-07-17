package com.fekra.userapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.rupins.drawercardbehaviour.CardDrawerLayout;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String MY_GLOBAL_PREFS = "MY_GLOBAL_PREFS";

    ImageView iv_profile;
    TextView tv_name, tv_mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CardDrawerLayout drawer = (CardDrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.useCustomBehavior(Gravity.START); //assign custom behavior for "Left" drawer
        drawer.useCustomBehavior(Gravity.END); //assign custom behavior for "Right" drawer

        drawer.setViewScale(Gravity.START, 0.9f); //set height scale for main view (0f to 1f)
        drawer.setViewElevation(Gravity.START, 20);//set main view elevation when drawer open (dimension)
        drawer.setViewScrimColor(Gravity.START, Color.TRANSPARENT);//set drawer overlay coloe (color)
        drawer.setDrawerElevation(Gravity.START, 20);//set drawer elevation (dimension)

        drawer.setRadius(Gravity.START, 25);//set end container's corner radius (dimension)

        iv_profile = findViewById(R.id.iv_profile_image);
        tv_name = findViewById(R.id.tv_profile_name);
        tv_mail = findViewById(R.id.tv_email);


        SharedPreferences prefs = getSharedPreferences(MY_GLOBAL_PREFS, MODE_PRIVATE);
        if (!prefs.getBoolean("Is_Logged_In", false)) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        } else {
            Picasso.get().load(Uri.parse(prefs.getString("User_pp", null))).into(iv_profile);
            tv_name.setText(prefs.getString("User_name", "null"));
            tv_mail.setText(prefs.getString("User_email", "null"));
        }

    }

    @Override
    public void onBackPressed() {
        CardDrawerLayout drawer = (CardDrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_featured:
                startActivity(new Intent(MainActivity.this,FeaturedActivity.class));
                break;

        }


        CardDrawerLayout drawer = (CardDrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
