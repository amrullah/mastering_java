package com.company;

import java.util.*;

public class Theatre {
    private final String name;
//    any of these will run
    private List<Seat> seats = new ArrayList<>();
//    private Collection<Seat> seats = new ArrayList<>();
//    private Collection<Seat> seats = new LinkedList<>();
//    private Collection<Seat> seats = new HashSet<>();
//    private Collection<Seat> seats = new LinkedHashSet<>();

    public Theatre(String name, int numRows, int seatsPerRow) {
        this.name = name;
        int lastRow = 'A' + (numRows-1);

        for (char row='A'; row <= lastRow; row++) {
            for (int seatNum=1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Seat getMinSeat() {
        return Collections.min(seats);
    }

    public Seat getMaxSeat() {
        return Collections.max(seats);
    }

    public void shuffleSeats() {
        Collections.shuffle(seats);
    }

    public void sortSeatsAsc() {
        Collections.sort(seats);
    }
    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);

        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat > 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.printf("There is no seat %1$s\n", seatNumber);
            return false;
        }

    }

    public void printSeats() {
        for (Seat seat : seats) {
            System.out.print(seat + " ");
        }
        System.out.println();
    }

    private class Seat implements Comparable<Seat> {
        private String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean isReserved() {
            return reserved;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.printf("Seat %1$s reserved\n", this);
                return true;
            }
            return false;
        }

        public boolean cancel() {
            if (this.isReserved()) {
                this.reserved = false;
                System.out.printf("Reservation of seat %1$s cancelled\n", this);
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.seatNumber);
        }

        @Override
        public String toString() {
            return this.seatNumber;
        }
    }

}
