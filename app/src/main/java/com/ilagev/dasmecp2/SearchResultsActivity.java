package com.ilagev.dasmecp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ilagev.dasmecp2.models.TopTracks;
import com.ilagev.dasmecp2.models.Track;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        String id = this.getIntent().getExtras().getString("artistID");
        Call<TopTracks> call_async = MainActivity.apiService.getTopTracks(id);

        call_async.enqueue(new Callback<TopTracks>() {
            @Override
            public void onResponse(Response<TopTracks> response, Retrofit retrofit) {
                TopTracks topTracks = response.body();
                Log.i(MainActivity.LOG_TAG, topTracks.toString());
                SearchResultsActivity.this.processTopTracks(topTracks);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(MainActivity.LOG_TAG, t.getMessage());
            }
        });
    }

    private void processTopTracks(TopTracks topTracks) {
        List<String> trackNames = new ArrayList<String>();
        for (Track t : topTracks.getTracks()) {
            trackNames.add(t.getName());
        }
        ListView lv = (ListView) findViewById(R.id.canciones_buscadas);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                trackNames);
        lv.setAdapter(adaptador);
    }
}
