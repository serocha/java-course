package com.udemy;

public class Main {

    public static void main(String[] args) {

        Theater theater = new Theater("Lensic", 8, 12);
        //theater.getSeats();
        System.out.println("Each dot is a search iteration:");
        theater.reserveSeat("D12");
        theater.reserveSeat("H11");
        theater.reserveSeat("H11");
        theater.reserveSeat("H13");
    }
}
