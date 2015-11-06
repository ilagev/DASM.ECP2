package com.ilagev.dasmecp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ilagev.dasmecp2.models.Track;

import java.util.List;

/**
 * Created by lv on 6/11/15.
 */
public class TrackAdapter extends ArrayAdapter<Track> {

    static private Context context;
    private List<Track> tracks;

    public TrackAdapter(Context c, List<Track> tracks) {
        super(c, R.layout.row, tracks);
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
            convertView = inflater.inflate(R.layout.row, null);
        }

        Track track = this.tracks.get(position);

        if (track != null) {
            TextView tvName = (TextView) convertView.findViewById(R.id.song_name);
            tvName.setText(track.getName());

            TextView tvArtist = (TextView) convertView.findViewById(R.id.artist_name);
            tvArtist.setText(track.getArtists().get(0).getName());
        }

        Button b = (Button) convertView.findViewById(R.id.save);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TrackAdapter.context, tracks.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return  convertView;
    }


}
