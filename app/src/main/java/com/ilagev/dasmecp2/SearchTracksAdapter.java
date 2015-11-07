package com.ilagev.dasmecp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ilagev.dasmecp2.db.TrackDB;
import com.ilagev.dasmecp2.models.Track;

import java.util.List;

/**
 * Created by lv on 6/11/15.
 */
public class SearchTracksAdapter extends ArrayAdapter<Track> {

    static private Context context;
    private List<Track> tracks;

    public SearchTracksAdapter(Context c, List<Track> tracks) {
        super(c, R.layout.row_search_results, tracks);
        this.context = c;
        this.tracks = tracks;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_search_results, null);
        }

        Track track = this.tracks.get(position);

        if (track != null) {
            TextView tvName = (TextView) convertView.findViewById(R.id.song_name);
            tvName.setText(track.getName());

            TextView tvAlbum = (TextView) convertView.findViewById(R.id.album_name);
            tvAlbum.setText(track.getAlbum().getName());
        }

        Button b = (Button) convertView.findViewById(R.id.save);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchTracksAdapter.context, tracks.get(position).getName(), Toast.LENGTH_SHORT).show();
                TrackDB t = new TrackDB(
                    tracks.get(position).getName(),
                    tracks.get(position).getId(),
                    tracks.get(position).getTrackNumber(),
                    tracks.get(position).getAlbum().getName(),
                    tracks.get(position).getAlbum().getImages().get(0).getUrl(),
                    tracks.get(position).getArtists().get(0).getName());

                MainActivity.repo.add(t);
            }
        });

        return  convertView;
    }


}
