package com.company;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Name: %1$s, number: %2$s", name, number);
    }

    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
