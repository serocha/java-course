package com.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Lensic", 8, 12);
        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats); // passing desired ArrayList as arg to new ArrayList
        // shallow copy of theater.seats, separate ArrayLists pointing to the same objects in memory
        printList(seatCopy);
        seatCopy.get(1).reserve();
        theater.reserveSeat("A02"); // same pointer

        Collections.shuffle(seatCopy); // but they are separate ArrayLists
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theater.seats");
        printList(theater.seats);

        Theater.Seat minSeat = Collections.min(theater.seats);
        Theater.Seat maxSeat = Collections.max(seatCopy); // these work even though if it's been shuffled
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

        // Collections.copy() has its own little quirks
        List<Theater.Seat> newList = new ArrayList<>(theater.seats.size()); // this only gives it the capacity, contains none
        Collections.copy(newList, theater.seats); // of limited or unique use cases
        System.out.println();
    }

    public static void printList(List<Theater.Seat> list) {
        for (Theater.Seat seat : list) {
            System.out.print("  " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("====================================================");
    }

    public static void sortList(List<Theater.Seat> list) {
        // Collections offers efficient sorts over a bubble method
        for (int i=0; i<list.size()-1; i++) {
            for (int j=i+1; j<list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
