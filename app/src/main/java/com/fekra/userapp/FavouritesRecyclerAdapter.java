package com.fekra.userapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import Model.PlacesModel;

public class FavouritesRecyclerAdapter extends RecyclerView.Adapter<FavouritesRecyclerAdapter.favVH> {

    private Context mContext;
    private List<PlacesModel> Places;
    PlacesModel model;

    public FavouritesRecyclerAdapter(Context mContext, List<PlacesModel> places) {
        this.mContext = mContext;
        Places = places;
    }

    @NonNull
    @Override
    public favVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favourite_rv_row, parent, false);;
        return new favVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final favVH holder, int position) {

        model = Places.get(position);

        holder.tv_title.setText(model.getPlaceName());
        holder.tv_address.setText(model.getAddress());

        Picasso.get().load(model.getPhotos()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.fav_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_remove_favourite:
                    Toast.makeText(mContext, "remove from favourites", Toast.LENGTH_SHORT).show();
                    //add the logic here


                    return true;

                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return Places.size();
    }

    class favVH extends RecyclerView.ViewHolder{
        TextView tv_title , tv_address;
        ImageView thumbnail,overflow;
        RelativeLayout rl;


        public favVH(View itemView) {
            super(itemView);

            tv_address=itemView.findViewById(R.id.address_fav);
            tv_title= itemView.findViewById(R.id.title_fav);
            thumbnail = itemView.findViewById(R.id.thumbnail_fav);
            overflow = itemView.findViewById(R.id.overflow);
            rl=itemView.findViewById(R.id.rl_fav_view);
        }
    }
}
