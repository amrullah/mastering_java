package com.company;

import static com.company.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me up");
        }
        System.out.println(ANSI_BLUE + "I'm awake after sleeping for 3 seconds");
    }
}
