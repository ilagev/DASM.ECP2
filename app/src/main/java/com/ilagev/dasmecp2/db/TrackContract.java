package com.ilagev.dasmecp2.db;

import android.provider.BaseColumns;

public abstract class TrackContract {

    public TrackContract() {}

    public static class tablaCanciones implements BaseColumns {

        public static final String TABLE_NAME = "tracks";

        public static final String COL_NAME_ID = _ID;
        public static final String COL_NAME_NAME = "name";
        public static final String COL_NAME_ID_SPOTIFY = "id_spotify";
        public static final String COL_NAME_NUMBER = "numero";
        public static final String COL_NAME_ALBUM = "album";
        public static final String COL_NAME_ALBUM_IMAGE = "album_imagen";
        public static final String COL_NAME_ARTIST = "artist";

    }

}
