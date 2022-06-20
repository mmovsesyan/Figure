package com.movsisyan.model;

import com.movsisyan.interfaces.Figure;

import java.util.Objects;
import java.util.StringJoiner;

public class Rectangle implements Figure {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toCSV() {
        StringJoiner stringJoiner = new StringJoiner(";");
        stringJoiner.add(this.getName());
        stringJoiner.add(String.valueOf(this.a));
        stringJoiner.add(String.valueOf(this.b));
        stringJoiner.add(String.valueOf(this.square()));
        stringJoiner.add(String.valueOf(this.perimeter()));
        return stringJoiner.toString();
    }

    public Rectangle() {
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public double square() {
        return a * b;
    }

    @Override
    public double perimeter() {
        return 2 * (a + b);
    }

    @Override
    public String getName() {
        return Rectangle.class.getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return a == rectangle.a && b == rectangle.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
