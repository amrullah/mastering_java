package com.company;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");
        Thread anotherThread = new AnotherThread();  // using a class
        anotherThread.setName("--- Another Thread ---");
        anotherThread.start();
        new Thread() {  // using an anonymous class
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous class thread");
            }
        }.start();

        new Thread(new MyRunnable() {  // using Runnable interface
            @Override
            public void run() {
                super.run();
                System.out.println(ANSI_RED + "Hello from Anonymous Runnable");;
            }
        }).start();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");
        // anotherThread.start();  // this will give IllegalThreadStateException
    }
}
