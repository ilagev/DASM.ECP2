package com.ilagev.dasmecp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilagev.dasmecp2.db.TrackDB;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SavedTracksAdapter extends ArrayAdapter<TrackDB> {

    static private Context context;
    private List<TrackDB> tracks;

    public SavedTracksAdapter(Context c, List<TrackDB> tracks) {
        super(c, R.layout.row_main_activity, tracks);
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
            convertView = inflater.inflate(R.layout.row_main_activity, null);
        }

        TrackDB track = this.tracks.get(position);

        if (track != null) {
            TextView tvName = (TextView) convertView.findViewById(R.id.song);
            tvName.setText(track.getName());

            TextView tvAlbum = (TextView) convertView.findViewById(R.id.album);
            tvAlbum.setText(track.getAlbumName());

            ImageView iv = (ImageView) convertView.findViewById(R.id.image_album);
            Picasso.with(context).load(track.getAlbumURLImage()).into(iv);
        }

        return  convertView;
    }


}
