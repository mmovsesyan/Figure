package com.movsisyan.program;

import com.movsisyan.enums.Functor;
import com.movsisyan.fabric.Fabric;
import com.movsisyan.fabric.RectangleFabric;
import com.movsisyan.fabric.TriangleFabric;
import com.movsisyan.interfaces.Figure;
import com.movsisyan.model.Calculator;
import com.movsisyan.model.Rectangle;
import com.movsisyan.model.Triangle;
import com.movsisyan.repository.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Map<String, Fabric> fabricMap = new HashMap<>();

        fabricMap.put("Triangle", new TriangleFabric());
        fabricMap.put("Rectangle", new RectangleFabric());

        Triangle triangle1 = new Triangle(2, 3, 4);
        Rectangle rectangle1 = new Rectangle(2, 1);
        try {
            Repository.replaceFigure("figures.csv", triangle1, rectangle1, fabricMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter count figures");
        int n = scanner.nextInt();
        ArrayList<Figure> figures = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            System.out.println("1-rectangle, 2-triangle, 3-circle");
            int number = scanner.nextInt();
            if (number == 1) {
                double v = scanner.nextDouble();
                double v1 = scanner.nextDouble();
                Rectangle rectangle = new Rectangle(v, v1);
                figures.add(rectangle);
            } else if (number == 2) {
                double v = scanner.nextDouble();
                double v1 = scanner.nextDouble();
                double v2 = scanner.nextDouble();
                Triangle triangle = new Triangle(v, v1, v2);
                figures.add(triangle);
            } else if (number == 3) {
                double v = scanner.nextDouble();
                Calculator calculator = new Calculator(new Figure() {
                    double R;

                    public void setR(double r) {
                        R = r;
                    }

                    @Override
                    public double square() {
                        return Math.PI * (R * R);
                    }

                    @Override
                    public double perimeter() {
                        return Math.PI * 2 * R;
                    }

                    @Override
                    public String getName() {
                        return null;
                    }

                    @Override
                    public String toCSV() {
                        return null;
                    }
                });
                System.out.println(calculator.calculate(Functor.PERIMETER));
            }
        }
//        System.out.println(Repository.maxFigures(figures, Functor.PERIMETER));
//        System.out.println(Repository.figures(figures, Functor.SQUARE));


    }
}
