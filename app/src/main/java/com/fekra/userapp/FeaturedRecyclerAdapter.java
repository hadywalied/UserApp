package com.fekra.userapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import Model.PlacesModel;

public class FeaturedRecyclerAdapter extends RecyclerView.Adapter<FeaturedRecyclerAdapter.myVH> {

    private Context mContext;
    private List<PlacesModel> Places;
    PlacesModel model;


    public FeaturedRecyclerAdapter(Context context, List<PlacesModel> mPlaces) {

        mContext = context;
        Places=mPlaces;
    }

    @NonNull
    @Override
    public myVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.featured_rv_row, parent, false);

        return new myVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myVH holder, int position) {


        model = Places.get(position);

        holder.title.setText(model.getPlaceName());
        holder.address.setText(model.getAddress());

        Picasso.get().load(model.getPhotos()).into(holder.thumbnail);

        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailsScrollingActivity.class);
                intent.putExtra("Photo",model.getPhotos());
                intent.putExtra("name",model.getPlaceName());
                intent.putExtra("desc",model.getDesc());
                //add what you need also
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Places.size();
    }

    class myVH extends RecyclerView.ViewHolder {
        public TextView title, address;
        public ImageView thumbnail;
        RelativeLayout rl;


        public myVH(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            address = view.findViewById(R.id.address);
            thumbnail = view.findViewById(R.id.thumbnail);
            rl=view.findViewById(R.id.rl_view);

        }


    }
}
