package com.bittech.java4;

public class Rectangle implements IShape {


    private double width;
    private double height;

    public Rectangle() {}

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double cycle() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
