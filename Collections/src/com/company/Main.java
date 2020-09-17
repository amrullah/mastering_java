package com.company;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("PVR", 8, 12);
//        theatre.getSeats();

        if (theatre.reserveSeat("H11")) {
            System.out.println("Please Pay");
        } else {
            System.out.println("Could not reserve the seat");
        }

    }
}
