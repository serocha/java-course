package com.udemy;

import java.util.ArrayList;

public class Album {

    private final String artist;
    private final String albumTitle;
    private final ArrayList<Song> tracks;

    public Album(String artist, String albumTitle) {
        this.artist = artist;
        this.albumTitle = albumTitle;
        tracks = new ArrayList<>();
    }

    public void addTrack(String title, double duration) {
        tracks.add(new Song(artist, title, duration));
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public ArrayList<Song> getTracks() {
        return tracks;
    }
}
