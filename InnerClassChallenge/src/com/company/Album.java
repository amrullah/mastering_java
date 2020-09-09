package com.company;

import java.util.*;

public class Album {
    private static final Scanner scanner = new Scanner(System.in);
    private String name;
    private SongList songList;

    public Album(String name) {
        this.name = name;
        this.songList = new SongList();
    }

    public void addSong(String title, int duration) {
        Song song = new Song(title, duration);
        songList.addSong(song);
    }

    public void addToPlaylist(String title, List<Song> playlist) {
        Song song = songList.findSong(title);

        if (song != null) {
            playlist.add(song);
            System.out.printf("%1$s song added to playlist\n", song);
        } else {
            System.out.println("No such song found");
        }
    }

    public void addToPlaylist(List<Song> playlist) {
        System.out.println("Please mention what songs you want to add to playlist");
        Iterator<Song> i = songList.getIterator();

        while (i.hasNext()) {
            Song song = i.next();
            System.out.printf("Do you want to add %1$s to playlist? y/n\n", song);
            String input = scanner.nextLine();

            if (input.toLowerCase().equals("y")) {
                playlist.add(song);
            }
        }
    }

    // SongList inner class
    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        private void addSong(Song song) {
            songs.add(song);
        }

        private Song findSong(String title) {
            Song neededSong = null;
            for (Song song : songs) {
                if (song.isTitle(title)) {
                    neededSong = song;
                    break;
                }
            }
            return neededSong;
        }

        private Iterator<Song> getIterator() {
            return songs.listIterator();
        }
    }
}
