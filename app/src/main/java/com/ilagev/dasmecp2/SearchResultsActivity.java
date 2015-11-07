package com.ilagev.dasmecp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ilagev.dasmecp2.models.TopTracks;
import com.ilagev.dasmecp2.models.Track;

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
                SearchResultsActivity.this.processTopTracks(topTracks);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(MainActivity.LOG_TAG, t.getMessage());
            }
        });
        setResult(RESULT_OK);
    }

    private void processTopTracks(final TopTracks topTracks) {
        ListView lv = (ListView) findViewById(R.id.canciones_buscadas);
        ArrayAdapter<Track> adapter = new SearchTracksAdapter(this, topTracks.getTracks());
        lv.setAdapter(adapter);
    }
}
