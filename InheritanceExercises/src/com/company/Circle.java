package com.company;

public class Circle {
    private final double radius;

    public Circle(double radius) {
        if (radius < 0.0) {
            radius = 0.0;
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
