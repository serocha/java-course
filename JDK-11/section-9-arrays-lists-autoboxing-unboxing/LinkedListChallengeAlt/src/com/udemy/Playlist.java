package com.udemy;

import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

    String name;
    LinkedList<Song> playlist;

    public Playlist(String name) {
        this.name = name;
        playlist = new LinkedList<>();
    }

    public void runPlaylist() {
        boolean isRunning = true;
        boolean goingForward = true;
        String menuOptions = """
                0 --> Quit Playlist
                1 --> Next Song
                2 --> Previous Song
                3 --> Repeat
                4 --> Delete from Playlist""";
        ListIterator<Song> songListIterator = playlist.listIterator();
        Song currentSong = songListIterator.next();
        System.out.println("Now playing:\n" + currentSong.toString());
        while(isRunning) {
            int input = Main.scanner.nextInt();
            Main.scanner.nextLine(); // clear buffer after int
            switch(input) {
                case 0 -> {
                    System.out.println("Stopping playlist...");
                    isRunning = false;
                }
                case 1 -> {
                    if (songListIterator.hasNext()) {
                        if (!goingForward) {
                            songListIterator.next();
                            goingForward = true;
                        }
                        if (songListIterator.hasNext()) {
                            System.out.println("Song skipped.");
                            currentSong = songListIterator.next();
                        } else {
                            System.out.println("At end of playlist.");
                        }
                        System.out.println("Now playing:\n" + currentSong);
                    } else {
                        System.out.println("At end of playlist.");
                        System.out.println("Now playing:\n" + currentSong);
                    }
                }
                case 2 -> {
                    if (songListIterator.hasPrevious()) {
                        if (goingForward) {
                            currentSong = songListIterator.previous();
                            goingForward = false;
                        }
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Going back.");
                            currentSong = songListIterator.previous();
                        } else {
                            System.out.println("At playlist start.");
                        }
                        System.out.println("Now playing:\n" + currentSong);
                    } else {
                        System.out.println("At playlist start.");
                        System.out.println("Now playing:\n" + currentSong);
                    }
                }
                case 3 -> {
                    System.out.println("Repeating song.");
                    System.out.println("Now playing:\n" + currentSong);
                }
                case 4 -> {
                    System.out.println("Deleting " + currentSong.getTitle() + " from playlist");
                    songListIterator.remove();
                    if (songListIterator.hasNext()) {
                        currentSong = songListIterator.next();
                        goingForward = true;
                        System.out.println("Now playing:\n" + currentSong);
                    } else if (songListIterator.hasPrevious()) {
                        currentSong = songListIterator.previous();
                        goingForward = false;
                        System.out.println("Now playing:\n" + currentSong);
                    } else {
                        System.out.println("No more songs in playlist. Exiting...");
                        isRunning = false;
                    }
                }
                case 5 -> System.out.println(menuOptions);
                default -> System.out.println("Something went wrong...");
            }
        }
    }

    public void addToPlaylist(Song songToAdd) {
        if (songToAdd == null) {
            System.out.println("No song found.");
            return;
        }
        if (findSong(songToAdd.getTitle()) == null) {
            playlist.add(songToAdd);
        } else {
            System.out.println("Song already in playlist.");
        }
    }

    public void deleteFromPlaylist(String songName) {

    }

    private Song findSong(String songTitle) {
        for (Song song : playlist) {
            if (song.getTitle().equals(songTitle)) {
                return song;
            }
        }
        return null;
    }
}
