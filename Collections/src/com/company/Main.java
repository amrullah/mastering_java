package com.company;

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
