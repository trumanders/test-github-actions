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

    public double getSquareRootOf(double number) {
        return Math.sqrt(number);
    }

    public double getAreaOfCircle(double radius) {
        if (radius < 0) {
            return Double.NaN;
        }
        return roundToTwoDecimals(Math.PI * (radius * radius));
    }

    public double getCircumferenceOfCircle(double radius) {
        if (radius < 0) {
            return Double.NaN;
        }
        return roundToTwoDecimals(Math.PI * 2 * radius);
    }

    private double roundToTwoDecimals(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
