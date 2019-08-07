package com.bittech.java4;

public class Circular implements  IShape {
    private double radius;

    public Circular() {}

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double cycle() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
