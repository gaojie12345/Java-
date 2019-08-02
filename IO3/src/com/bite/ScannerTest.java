package com.bite;

import javafx.scene.shape.SVGPath;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println("输入内容为：" +str);
        }
    }
}
