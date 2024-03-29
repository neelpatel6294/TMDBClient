package com.androidtutz.anushka.tmdbclient.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidtutz.anushka.tmdbclient.R;
import com.androidtutz.anushka.tmdbclient.model.Movie;
import com.androidtutz.anushka.tmdbclient.model.RelatedTopic;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/10/2018.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private Context context;
    private ArrayList<RelatedTopic> movieArrayList;

    public MovieAdapter(Context context, ArrayList<RelatedTopic> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        holder.movieTitle.setText(movieArrayList.get(position).getText());
//        holder.rate.setText(Double.toString(movieArrayList.get(position).getVoteAverage()));
//
//        String imagePath="https://image.tmdb.org/t/p/w500"+movieArrayList.get(position).getPosterPath();
//
//        Glide.with(context)
//                .load(imagePath)
//                .placeholder(R.drawable.loading)
//                .into(holder.movieImage);


    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {


        public TextView movieTitle, rate;
        public ImageView movieImage;

        public MovieViewHolder(View itemView) {
            super(itemView);

//            movieImage = (ImageView) itemView.findViewById(R.id.ivMovie);
//            rate = (TextView) itemView.findViewById(R.id.tvRating);
            movieTitle = (TextView) itemView.findViewById(R.id.tvTitle);


        }
    }
}
