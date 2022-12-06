package com.udemy;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.eat();
        dog.breathe();

        //Bird bird = new Bird("Parrot"); can't directly instantiate an abstract
        Parrot parrot = new Parrot("Australian ringneck");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor penguin");
        penguin.eat();
        penguin.breathe();
        penguin.fly();
        penguin.swim();
    }
}
