package com.ilagev.dasmecp2;

import com.ilagev.dasmecp2.models.Artists;
import com.ilagev.dasmecp2.models.TopTracks;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface SpotifyAPIService {

    @GET("/v1/artists/{id}/top-tracks?country=ES")
    Call<TopTracks> getTopTracks(@Path("id") String artistId);

    @GET("/v1/search?type=artist")
    Call<Artists> getArtists(@Query("q") String q);

}