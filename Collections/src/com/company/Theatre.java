package com.company;

import java.util.*;

public class Theatre {
    private final String name;
    static final Comparator<Seat> PRICE_COMPARATOR;

    static {
        PRICE_COMPARATOR = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                }
                return 0;
            }
        };
    }

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
                double price = getPrice(row, seatNum);

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    private double getPrice(char row, int seatNum) {
        double price = 12.0;
        if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
            price += 2.0;
        } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
            price -= 5.0;
        }
        return price;
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

    public void sortSeatsByPrice() {
        Collections.sort(seats, PRICE_COMPARATOR);
    }
    public void reverseSeats() {
        Collections.reverse(seats);
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0.0);

        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat > 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.printf("There is no seat %1$s\n", seatNumber);
            return false;
        }

    }

    public Collection<Seat> getSeats() {
        return this.seats;
    }
    public void printSeats() {
        for (Seat seat : seats) {
            System.out.print(seat + " | ");
        }
        System.out.println();
    }

    private class Seat implements Comparable<Seat> {
        private String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
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

        public double getPrice() {
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.seatNumber);
        }

        @Override
        public String toString() {
            return String.format("%1$s for $%2$s", this.seatNumber, this.price);
        }
    }

}
