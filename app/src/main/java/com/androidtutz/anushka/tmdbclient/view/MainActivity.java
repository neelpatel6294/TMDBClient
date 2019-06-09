package com.androidtutz.anushka.tmdbclient.view;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidtutz.anushka.tmdbclient.R;
import com.androidtutz.anushka.tmdbclient.adapter.MovieAdapter;
import com.androidtutz.anushka.tmdbclient.model.Movie;
import com.androidtutz.anushka.tmdbclient.model.MovieDBResponse;
import com.androidtutz.anushka.tmdbclient.model.One;
import com.androidtutz.anushka.tmdbclient.model.RelatedTopic;
import com.androidtutz.anushka.tmdbclient.service.MovieDataService;
import com.androidtutz.anushka.tmdbclient.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<RelatedTopic> movies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("TMDB Popular Movies Today");

        getPopularMovies();
    }

    public void getPopularMovies() {

        MovieDataService movieDataService = RetrofitInstance.getService();

        Call<One> call = movieDataService.getPopularMovies();

        call.enqueue(new Callback<One>() {
            @Override
            public void onResponse(Call<One> call, Response<One> response) {

                One movieDBResponse = response.body();


                if (movieDBResponse != null && movieDBResponse.getRelatedTopics() != null) {


                    movies = (ArrayList<RelatedTopic>) movieDBResponse.getRelatedTopics();
                    showOnRecyclerView();


                }


            }

            @Override
            public void onFailure(Call<One> call, Throwable t) {

            }
        });

    }

    private void showOnRecyclerView() {

        recyclerView = findViewById(R.id.rvMovies);
        movieAdapter = new MovieAdapter(this, movies);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();

    }
}
