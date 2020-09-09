package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static final LinkedList<Song> playlist = new LinkedList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*
        Create a program that implements a playlist for songs.
        Create a Song class having title and duration of song

        There will be an Album class containing an inner class called SongList.
        The inner SongList class will use an ArrayList and will provide a method to add a song.
        Songs from different albums can be added to the Playlist.

        Once the songs have been added to the playlist, create a menu of options to:
        Quit, Skip Forward to the next song, Skip backward to the previous song, Replay the current song,
        List the songs in the playlist, and additionally, remove a song from the playlist.

        A song must exist in the album before it can be added to the playlist


        inner class SongList will also provide findSong() method which will be used by containing Album class to add
        Songs to the PlayList.
         */

        Album album1 = new Album("Favourites");

        album1.addSong("Kuch Kuch Hota hai", 5);
        album1.addSong("Ye kaali kaali aankhe", 4);
        album1.addSong("I am a disco dancer", 6);
        album1.addSong("Jaa Chudail", 5);
        album1.addSong("Bole Chudiya", 5);

        album1.addToPlaylist(playlist);

        printPlayList();

        playlistOperations();
    }

    private static void playlistOperations() {
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> i = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist");
            return;
        } else {
            printOptions();
            System.out.printf("Now playing %1$s\n", i.next());
        }

        while (!quit) {
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Bye Bye!");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (i.hasNext()) {
                            i.next();
                        }
                        forward = true;
                    }

                    if (i.hasNext()) {
                        System.out.printf("Now playing %1$s\n", i.next());
                    } else {
                        System.out.println("End of playlist reached!");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (i.hasPrevious()) {
                            i.previous();
                        }
                        forward = false;
                    }

                    if (i.hasPrevious()) {
                        System.out.printf("Now playing %1$s\n", i.previous());
                    } else {
                        System.out.println("Start of the playlist reached!");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (i.hasPrevious()) {
                            System.out.printf("Now playing %1$s\n", i.previous());
                            forward = false;
                        } else {
                            System.out.println("Start of the playlist reached");
                        }
                    } else {
                        if (i.hasNext()) {
                            System.out.printf("Now playing %1$s\n", i.next());
                            forward = true;
                        } else {
                            System.out.println("End of the playlist reached");
                        }
                    }
                    break;
                case 4:
                    printPlayList();
                    break;
                case 6:
                    if(playlist.size() >0) {
                        i.remove();
                        if(i.hasNext()) {
                            System.out.println("Now playing " + i.next());
                        } else if(i.hasPrevious()) {
                            System.out.println("Now playing " + i.previous());
                        }
                    }
                    break;
                default:
                    printOptions();
                    break;

            }
        }
    }

    private static void printOptions() {
        System.out.println("Available actions:");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available options.\n" +
                "6 - delete current song from playlist");
    }

    private static void printPlayList() {
        System.out.println("Songs currently in the Playlist:");
        for (Song song : playlist) {
            System.out.println("\t" + song);
        }
        System.out.println();
    }
}
