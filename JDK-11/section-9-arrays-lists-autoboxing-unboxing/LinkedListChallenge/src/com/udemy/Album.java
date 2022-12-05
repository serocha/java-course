package com.udemy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

// not quite sure how this assignment showcases LinkedLists
public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album (String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        Song song = findSong(title);
        if (song == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if (trackNumber <= songs.size() && trackNumber > 0) {
            Song song = songs.get(trackNumber-1);
            for (Song playlistSong : playlist) {
                if (playlistSong.getTitle().equals(song.getTitle())) {
                    return false;
                }
            }
            playlist.add(song);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        Song song = findSong(songTitle);
        if (song != null) {
            for (Song playlistSong : playlist) {
                if (playlistSong.getTitle().equals(songTitle)) {
                    return false;
                }
            }
            playlist.add(song);
            return true;
        }
        return false;
    }

    private Song findSong(String songTitle) {
        ListIterator<Song> songList = songs.listIterator();
        // (Song song : songs) to iterate, but ListIterator for practice
        while (songList.hasNext()) {
            Song song = songList.next();
            if (song.getTitle().equals(songTitle)) {
                return song;
            }
        }
        return null;
    }
}
