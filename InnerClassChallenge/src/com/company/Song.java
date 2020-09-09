package com.company;

public class Song {
    private String title;
    private int durationMinutes;

    public Song(String title, int durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    public boolean isTitle(String title) {
        return this.title.equals(title);
    }

    @Override
    public String toString() {
        return this.title;
    }
}
