package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Writer(message)).start();
        new Thread(new Reader(message)).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (this.empty) {
            try {
                wait(); // wait the thread till some other thread notifies to resume
            } catch (InterruptedException e) {

            }
        }
        this.empty = true;
        notifyAll();  // notify other threads holding this object to resume
        return this.message;
    }

    public synchronized void write(String message) {
        while (!this.empty) {
            try {
                wait(); // wait the thread till some other thread notifies to resume
            } catch (InterruptedException e) {

            }
        }
        this.empty = false;
        this.message = message;
        notifyAll();  // notify other threads holding this object to resume
    }
}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = {
            "Humpty Dumpty sat on a wall",
            "Humpty Dumpty had a great fall",
            "All the king's horses and all the king's men",
            "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for (int i=0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();

        for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}