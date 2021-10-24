package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock(true);  // try to let the longest waiting thread acquire the lock
        MyProducer producer = new MyProducer(buffer, bufferLock, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, bufferLock, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, bufferLock, ThreadColor.ANSI_CYAN);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> stringFuture = executorService.submit(() -> "This is the Callable Result");

        try {
            System.out.println(ThreadColor.ANSI_WHITE + "String Future result: " +stringFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Something went wrong trying to fetch the future result");
        }
        executorService.shutdown();  // don't forget this
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
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add(Main.EOF);
        } finally {
            bufferLock.unlock();
        }
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

            try {
                if (bufferLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    try {
                        if (buffer.isEmpty()) {
                            continue;
                        }
                        if (buffer.get(0).equals(Main.EOF)) {
                            System.out.println(color + "Exiting");
                            break;
                        } else {
                            System.out.println(color + "Removed " + buffer.remove(0));
                        }
                    } finally {
                        bufferLock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

    }
}