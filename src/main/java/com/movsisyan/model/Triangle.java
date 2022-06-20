package com.movsisyan.model;

import com.movsisyan.interfaces.Figure;

import java.util.Objects;
import java.util.StringJoiner;

public class Triangle implements Figure {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toCSV() {
        StringJoiner stringJoiner = new StringJoiner(";");
        stringJoiner.add(this.getName());
        stringJoiner.add(String.valueOf(this.a));
        stringJoiner.add(String.valueOf(this.b));
        stringJoiner.add(String.valueOf(this.c));
        stringJoiner.add(String.valueOf(this.square()));
        stringJoiner.add(String.valueOf(this.perimeter()));
        return stringJoiner.toString();
    }

    public Triangle() {
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

    public double getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public double square() {
        return 0.5 * (a * b);
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public String getName() {
        return Triangle.class.getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return a == triangle.a && b == triangle.b && c == triangle.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
