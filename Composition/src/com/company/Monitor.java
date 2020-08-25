package com.company;

public class Monitor {
    private String model;
    private String manufacturer;
    private int size;

    private Resolution resolution;  // composition

    public Monitor(String model, String manufacturer, int size, Resolution resolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.printf("Drawing pixel at %1$s, %2$s in color %3$s\n", x, y, color);
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getResolution() {
        return resolution;
    }
}
