package com.udemy;

import java.util.ArrayList;
import java.util.LinkedList;

// not quite sure how this assignment showcases LinkedLists
public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album (String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public static class SongList {
        // defined public static for eval purposes
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {
            for (Song songOnAlbum : this.songs) {
                if (songOnAlbum.getTitle().equals(song.getTitle())) {
                    return false;
                }
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String songTitle) {
            for (Song song : this.songs) {
                if (song.getTitle().equals(songTitle)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            if (this.songs.size() >= trackNumber) {
                return this.songs.get(trackNumber-1);
            }
            return null;
        }
    }

    public boolean addSong(String title, double duration) {
        Song song = songs.findSong(title);
        if (song == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song song = songs.findSong(trackNumber);
        if (song != null) {
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
        Song song = songs.findSong(songTitle);
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
}
