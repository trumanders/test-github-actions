package org.example;

public class Calculator {

    public double getSumOf(double a, double b) {
        return a + b;
    }

    public double getDifferenceOf(double a, double b) {
        return a - b;
    }

    public double getProductOf(double a, double b) {
        return a * b;
    }

    public double getQuotientOf(double a, double b) {
        return a / b;
    }

    private double roundToTwoDecimals(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
