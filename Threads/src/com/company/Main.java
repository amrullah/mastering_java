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
                try {
                    anotherThread.join(2*1000);
                    System.out.println(ANSI_RED + "AnotherThread terminated/timed out. Now I'll continue");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted");
                }
            }
        }).start();
//        anotherThread.interrupt();
        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");
        // anotherThread.start();  // this will give IllegalThreadStateException
    }
}
