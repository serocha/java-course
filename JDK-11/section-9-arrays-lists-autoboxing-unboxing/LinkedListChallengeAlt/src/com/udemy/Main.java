package com.udemy;

/*      Slightly different assignment from the other playlist challenge

        Implement a playlist for songs
        Song and album class, albums stored in an ArrayList
        Songs preloaded to playlist, which has a menu implemented
        Options to quit, skip forward, skip back, repeat, and delete song from playlist
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Album> albums = new ArrayList<>();

        Album album0 = new Album("Moderat", "III");
        album0.addTrack("Eating Hooks", 4.32);
        album0.addTrack("Running", 3.51);
        album0.addTrack("Finder", 5.2);
        album0.addTrack("Ghost Mother", 5.57);
        album0.addTrack("Reminder", 3.54);
        album0.addTrack("The Fool", 4.12);
        album0.addTrack("Intruder", 4.38);
        album0.addTrack("Animal Trails", 4.38);
        album0.addTrack("Ethereal", 5.28);
        albums.add(album0);

        Album album1 = new Album("Yeah Yeah Yeahs", "Fever to Tell");
        album1.addTrack("Rich", 3.36);
        album1.addTrack("Date With The Night", 2.35);
        album1.addTrack("Man", 1.5);
        album1.addTrack("Tick", 1.5);
        album1.addTrack("Black Tongue", 2.59);
        album1.addTrack("Pin", 2.01);
        album1.addTrack("Cold Light", 2.16);
        album1.addTrack("No No No", 5.14);
        album1.addTrack("Maps", 3.4);
        album1.addTrack("Y Control", 4.02);
        album1.addTrack("Modern Romance/Poor Song", 7.28);
        albums.add(album1);

        Playlist playlist = new Playlist("My Playlist");
        playlist.addToPlaylist(findSong(album0, "Ethereal"));
        playlist.addToPlaylist(findSong(album1, "Cold Light"));
        playlist.addToPlaylist(findSong(album0, "Finder"));
        playlist.addToPlaylist(findSong(album1, "Maps"));
        playlist.addToPlaylist(findSong(album0, "The Fool"));
        playlist.addToPlaylist(findSong(album1, "Date With The Night"));
        playlist.addToPlaylist(findSong(album1, "Y Control"));
        playlist.addToPlaylist(findSong(album0, "Running"));
        playlist.addToPlaylist(findSong(album1, "Pin"));
        playlist.addToPlaylist(findSong(album1, "Modern Romance/Poor Song"));

        playlist.runPlaylist();
    }

    public static Song findSong(Album album, String songTitle) {
        for (Song song : album.getTracks()) {
            if (song.getTitle().equals(songTitle)) {
                return song;
            }
        }
        return null;
    }
}
