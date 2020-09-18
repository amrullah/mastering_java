package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final Theatre theatre;

    public static void main(String[] args) {

        Main main = new Main();
        main.theatre.printSeats();
        main.attemptToReserve("H11");
        main.attemptToReserve("H11");

        main.theatre.shuffleSeats();
        main.theatre.printSeats();

        System.out.printf("First seat: %1$s\n", main.theatre.getMinSeat());
        System.out.printf("Last seat: %1$s\n", main.theatre.getMaxSeat());

        main.theatre.sortSeatsAsc();
        main.theatre.printSeats();

        main.theatre.sortSeatsByPrice();
        main.theatre.reverseSeats();
        main.theatre.printSeats();

        mapDemo();
    }

    private static void mapDemo() {
        System.out.println("----------------------------");
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "good language");
        languages.put("Python", "very good language");
        System.out.println(languages.put("Golang", "mind blowing language"));  // null

        System.out.println(languages.put("Java", "breath-taking language"));  // put() returns old value for the key
        System.out.println(languages.get("Java"));  // new value

        System.out.println(languages.get("Python"));

        if (languages.containsKey("Golang")) {
            System.out.println("Golang exists in the map");
        }

        for (String key : languages.keySet()) {
            System.out.printf("%1$s => %2$s\n", key, languages.get(key));
        }
    }

    public Main() {
        this.theatre = new Theatre("PVR", 8, 12);
    }

    public void attemptToReserve(String seatNumber) {
        if (this.theatre.reserveSeat(seatNumber)) {
            System.out.println("Please Pay");
        } else {
            System.out.println("Could not reserve the seat");
        }
    }
}
