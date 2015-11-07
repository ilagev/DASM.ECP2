package com.ilagev.dasmecp2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.ilagev.dasmecp2.db.TrackContract.tablaCanciones;

public class RepoTracks extends SQLiteOpenHelper {

    private static final String DATABASE_FILENAME = "tracks.db";

    private static final int DATABASE_VERSION = 1;

    public RepoTracks(Context context) {
        super(context, DATABASE_FILENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sentenciaSQL = "CREATE TABLE " + tablaCanciones.TABLE_NAME + "("
                + tablaCanciones.COL_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tablaCanciones.COL_NAME_NAME + " TEXT, "
                + tablaCanciones.COL_NAME_ID_SPOTIFY + " TEXT, "
                + tablaCanciones.COL_NAME_NUMBER + " INTEGER, "
                + tablaCanciones.COL_NAME_ALBUM + " TEXT, "
                + tablaCanciones.COL_NAME_ALBUM_IMAGE + " TEXT, "
                + tablaCanciones.COL_NAME_ARTIST + " TEXT)";
        db.execSQL(sentenciaSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sentenciaSQL = "DROP TABLE IF EXISTS " + tablaCanciones.TABLE_NAME;
        db.execSQL(sentenciaSQL);
        onCreate(db);
    }

    public long add(TrackDB trackDB) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(tablaCanciones.COL_NAME_NAME, trackDB.getName());
        valores.put(tablaCanciones.COL_NAME_ID_SPOTIFY, trackDB.getId());
        valores.put(tablaCanciones.COL_NAME_NUMBER, trackDB.getNumber());
        valores.put(tablaCanciones.COL_NAME_ALBUM, trackDB.getAlbumName());
        valores.put(tablaCanciones.COL_NAME_ALBUM_IMAGE, trackDB.getAlbumURLImage());
        valores.put(tablaCanciones.COL_NAME_ARTIST, trackDB.getArtistName());

        return db.insert(tablaCanciones.TABLE_NAME, null, valores);
    }

    public ArrayList<TrackDB> getAll() {
        return getAll(tablaCanciones.COL_NAME_ID, true);
    }

    public ArrayList<TrackDB> getAll(String columna, boolean ordenAscendente) {
        ArrayList<TrackDB> result = new ArrayList<>();
        String q = "SELECT * FROM " + tablaCanciones.TABLE_NAME
                + " ORDER BY " + columna + (ordenAscendente ? " ASC" : " DESC");

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(q, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                TrackDB trackDB = new TrackDB(
                        cursor.getString(cursor.getColumnIndex(tablaCanciones.COL_NAME_NAME)),
                        cursor.getString(cursor.getColumnIndex(tablaCanciones.COL_NAME_ID_SPOTIFY)),
                        cursor.getInt(cursor.getColumnIndex(tablaCanciones.COL_NAME_NUMBER)),
                        cursor.getString(cursor.getColumnIndex(tablaCanciones.COL_NAME_ALBUM)),
                        cursor.getString(cursor.getColumnIndex(tablaCanciones.COL_NAME_ALBUM_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(tablaCanciones.COL_NAME_ARTIST))
                );
                result.add(trackDB);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return result;
    }

    public long count() {
        String consultaSQL = "SELECT COUNT(*) FROM " + tablaCanciones.TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(consultaSQL, null);
        cursor.moveToFirst();
        long numero = cursor.getLong(0);
        cursor.close();

        return numero;
    }

    public long deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tablaCanciones.TABLE_NAME, "1", null);
    }

}
