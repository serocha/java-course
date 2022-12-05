package com.udemy;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
/*      outer class (leaving all this for example purposes)
      Gearbox mcLaren = new Gearbox(6);
      to create a new inner class, you have to reference the instantiated outer class
      Gearbox.Gear first = mcLaren.new Gear(1, 12.3); // note syntax here
      Gearbox.Gear second = new Gearbox.Gear(2, 15.4) <-- this is instantiating a new gearbox, not the gear
      Gearbox.Gear third = new mcLaren.Gear(3, 17.8) <-- this is instantiating an unknown mcLaren class
      Gearbox.Gear second = mcLaren.new Gear(2, 15.4);
      Gearbox.Gear third = mcLaren.new Gear(3, 17.8);
      System.out.println(first.driveSpeed(1000));

      this showcases why it's important not to expose the gears, but instead give an interface to
      access them via the outer class
        Gearbox mcLaren = new Gearbox(6);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000))

        local class
        class ClickListener implements Button.OnClickListener {
            // this local class makes sense within the scope because it's only needed here
            // a little fake event listener to simulate a use case
            public ClickListener() {
                System.out.println("I've been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        }*/

        // anonymous class
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            // not a named class, overrode the necessary method as a parameter
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();
    }

    private static void listen() {
        boolean quit = false;

        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 -> quit=true;
                case 1 -> btnPrint.onClick();
            }
        }
    }
}
