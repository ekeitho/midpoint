package com.ekeitho.midpoint;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by ekeitho on 4/9/16.
 */
public class FriendsHistoryAdapter extends RecyclerView.Adapter<FriendsHistoryAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView names, dates, places;
        public ViewHolder(View v) {
            super(v);
            names = (TextView) v.findViewById(R.id.names);
            dates = (TextView) v.findViewById(R.id.dates);
            places = (TextView) v.findViewById(R.id.places);
            imageView = (ImageView) v.findViewById(R.id.main_card_image);
        }
    }

    int drawables[] = {R.drawable.amuse, R.drawable.outside, R.drawable.outside2,
                        R.drawable.tea, R.drawable.tea2};
    String place[] = {"La Flaminga", "Lake Tahoe", "Malibu", "Share Tea", "Little Cup Tea"};
    String times[] = {"January 1, 2016 @ 10PM", "December 3, 2015, @ 7PM", "November 24, 2015 @ 3PM"};

    Context mContext;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friends_history_detail, parent, false);
        mContext = parent.getContext();
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(mContext).load(drawables[position]).resize(400, 400).centerInside().into(holder.imageView);
        holder.places.setText(place[position]);
        holder.dates.setText(times[position % times.length]);
    }

    @Override
    public int getItemCount() {
        return drawables.length;
    }


}
