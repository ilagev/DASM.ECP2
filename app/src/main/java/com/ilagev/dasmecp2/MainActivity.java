package com.ilagev.dasmecp2;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.Toast;

import com.ilagev.dasmecp2.models.Artists;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String API_BASE_URL = "https://api.spotify.com";

    public static final String LOG_TAG = "Spotify_SONG_APP";

    public static SpotifyAPIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(SpotifyAPIService.class);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextChange(String newText) {
                return true;
            }

            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "Busqueda: " + query, Toast.LENGTH_LONG).show();

                Call<Artists> call_async = MainActivity.apiService.getArtists("artist:" + query);

                call_async.enqueue(new Callback<Artists>() {
                    @Override
                    public void onResponse(Response<Artists> response, Retrofit retrofit) {
                        Artists artists = response.body();
                        MainActivity.this.processArtistSet(artists);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e(LOG_TAG, t.getMessage());
                    }
                });

                return true;
            }
        });

        return true;
    }

    private void processArtistSet(Artists artists) {
        if (!artists.getArtists().getItems().isEmpty()) {
            String artistID = artists.getArtists().getItems().get(0).getId();

            Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
            intent.putExtra("artistID", artistID);

            startActivity(intent);
        }
    }
}
