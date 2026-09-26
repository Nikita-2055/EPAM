package com.epam.rd.qa.classes;

import java.util.Objects;

public class Rectangle {

    private double sideA;
    private double sideB;

    public Rectangle(double a, double b) {
        this.sideA = a;
        this.sideB = b;
    }

    public Rectangle(double side) {
        this.sideA = side;
        this.sideB = side;
    }

    public Rectangle() {
        this.sideA = 4;
        this.sideB = 3;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area() {
        return sideA * sideB;
    }

    public double perimeter() {
        return 2 * (sideA + sideB);
    }

    public boolean isSquare() {
        return sideA == sideB;
    }

    public void replaceSides() {
        double temp = sideA;
        sideA = sideB;
        sideB = temp;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.sideA, sideA) == 0 &&
                Double.compare(rectangle.sideB, sideB) == 0;
    }

    public int hashCode() {
        return Objects.hash(sideA, sideB);
    }

    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
}