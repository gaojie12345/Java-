package com.bittech.java;

import java.util.Date;

class Apple implements IFruit{
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

class Orange implements IFruit{
    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}

class FruitFactory{
    public FruitFactory() {}

    public static IFruit getInstance(String className) {
        IFruit fruit = null;
        try {
            fruit = (IFruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        IFruit fruit = FruitFactory.getInstance("com.bittech.java.Orange");
        fruit.eat();
    }
}
