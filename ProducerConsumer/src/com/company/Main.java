package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, bufferLock, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, bufferLock, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, bufferLock, ThreadColor.ANSI_CYAN);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {
    private final List<String> buffer;
    private final String color;
    private final ReentrantLock bufferLock;


    public MyProducer(List<String> buffer, ReentrantLock bufferLock, String color) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding... " + num);
                bufferLock.lock();
//                synchronized (buffer) {
                buffer.add(num);
//                }
                bufferLock.unlock();

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
//        synchronized (buffer) {
        buffer.add(Main.EOF);
//        }
        bufferLock.unlock();
    }
}

class MyConsumer implements Runnable {
    private final List<String> buffer;
    private final String color;
    private final ReentrantLock bufferLock;


    MyConsumer(List<String> buffer, ReentrantLock bufferLock, String color) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        while (true) {
            bufferLock.lock();
//            synchronized (buffer) {
            if (buffer.isEmpty()) {
                bufferLock.unlock();
                continue;
            }
            if (buffer.get(0).equals(Main.EOF)) {
                System.out.println(color + "Exiting");
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
                bufferLock.unlock();
            }
//            }

        }
        bufferLock.unlock();
    }
}