package com.ilagev.dasmecp2.db;

public class TrackDB {

    private String name;
    private String id;
    private Integer number;
    private String albumName;
    private String albumURLImage;
    private String artistName;

    public TrackDB(String name, String id, Integer number, String albumName, String albumURLImage, String artistName) {
        this.name = name;
        this.id = id;
        this.number = number;
        this.albumName = albumName;
        this.albumURLImage = albumURLImage;
        this.artistName = artistName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumURLImage() {
        return albumURLImage;
    }

    public void setAlbumURLImage(String albumURLImage) {
        this.albumURLImage = albumURLImage;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "TrackDB{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumURLImage='" + albumURLImage + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
