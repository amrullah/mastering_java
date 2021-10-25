package com.company;

public class Main {
    private Worker owner;

    public Main(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }

    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final Main sharedResource = new Main(worker1);

        new Thread(() -> {
            worker1.work(sharedResource, worker2);
        }).start();

        new Thread(() -> {
            worker2.work(sharedResource, worker1);
        }).start();
    }
}
