package com.udemy;

public class Main {

    public static void main(String[] args) {

        ITelephone myPhone;
        myPhone = new DeskPhone(4342027);

        myPhone.powerOn();
        myPhone.callPhone(4342027);
        myPhone.answer();

        // reassign myPhone to the new class, which wouldn't work if it had been a class declaration
        myPhone = new MobilePhone(5554545);
        // myPhone.powerOn();
        myPhone.callPhone(5554545);
        myPhone.answer();
    }
}
