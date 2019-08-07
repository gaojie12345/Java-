package com.bittech.java4;

public class MyCaluter {
    private IShape rectangle;
    private IShape circular;

    public MyCaluter() {
    }

    public IShape getRectangle() {
        return rectangle;
    }

    public void setRectangle(IShape rectangle) {
        this.rectangle = rectangle;
    }

    public IShape getCircular() {
        return circular;
    }

    public void setCircular(IShape circular) {
        this.circular = circular;
    }

    public IShape caculate_function(String shapName) {
        if (shapName.equals("rectangle"))
            return this.getRectangle();
        if (shapName.equals("circular"))
            return this.getCircular();
        return null;
    }

}
