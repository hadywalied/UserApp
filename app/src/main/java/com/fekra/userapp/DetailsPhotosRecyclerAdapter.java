package com.fekra.userapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class DetailsPhotosRecyclerAdapter extends RecyclerView.Adapter<DetailsPhotosRecyclerAdapter.VHDetails> {
    private Context mContext;
    private List<String> placePhotos;

    public DetailsPhotosRecyclerAdapter(Context mContext, List<String> placePhotos) {
        this.mContext = mContext;
        this.placePhotos = placePhotos;
    }

    @NonNull
    @Override
    public VHDetails onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_details_row, parent, false);


        return new VHDetails(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VHDetails holder, int position) {

        Picasso.get().load(placePhotos.get(position)).into(holder.iv_detailsImage);

    }

    @Override
    public int getItemCount() {
        return placePhotos.size();
    }

    class VHDetails extends RecyclerView.ViewHolder {
        ImageView iv_detailsImage;


        public VHDetails(View itemView) {
            super(itemView);
            iv_detailsImage = itemView.findViewById(R.id.iv_photos_details);
        }
    }
}
