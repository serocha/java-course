package com.udemy;

public class Song {

    private final String artist;
    private final String title;
    private final double duration; // abstraction equating to MM.SS format, e.g. 3.36 = 3:36

    public Song(String artist, String title, double duration) {
        this.artist = artist;
        this.title = title;
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " by " + artist + "\nDuration: " + duration;
    }
}
