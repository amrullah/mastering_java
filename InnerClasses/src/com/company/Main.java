package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button buttonPrint = new Button("Print");
    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);
//        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);  // correct, if inner class Gear was public, note mcLaren.new
//        Gearbox.Gear second = new Gearbox.Gear(2, 15.2);  // not allowed
//        Gearbox.Gear third = new mcLaren.Gear(3, 17.8);  // not allowed

        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);

        System.out.println("Wheel Speed is " + mcLaren.wheelSpeed(1000));

        mcLaren.operateClutch(true);
        mcLaren.changeGear(2);
        mcLaren.operateClutch(false);

        System.out.println("Wheel Speed is " + mcLaren.wheelSpeed(1000));

        // next section

        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.printf("%1$s was clicked\n", title);
            }
        }

        buttonPrint.setOnClickListener(new ClickListener());  // local class
        listen();
        buttonPrint.setOnClickListener(new Button.OnClickListener() {  // anonymous class
            @Override
            public void onClick(String title) {
                System.out.printf("%1$s was clicked, you are awesome!\n", title);
            }
        });
        listen();
    }
    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                default:
                    buttonPrint.onClick();
            }
        }
    }
}
