package com.movsisyan.repository;

import com.movsisyan.enums.Functor;
import com.movsisyan.fabric.Fabric;
import com.movsisyan.interfaces.Figure;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Repository {
    /**
     * 1.	В классе Repository реализовать метод, принимающий
     * на вход заполненное с клавиатуры множество различных
     * фигур, экземпляр перечисления и вычисляющий
     * фигуру с максимальным значением переданного перечисления
     */
    public static Figure maxFigures(ArrayList<Figure> figures, Functor functor) {
        double max = 0;
        Figure maxFigure = null;
        for (Figure figure : figures) {
            if (functor == Functor.PERIMETER) {
                if (figure.perimeter() > max) {
                    max = figure.perimeter();
                    maxFigure = figure;
                }
            } else if (functor == Functor.SQUARE) {
                if (figure.square() > max) {
                    max = figure.square();
                    maxFigure = figure;
                }
            }
        }
        return maxFigure;
    }

    /**
     * 2.	Реализовать метод, вычисляющий две наиболее
     * удаленные друг от друга фигуры по переданному
     * признаку-перечислению
     */
    public static ArrayList<Figure> figures(ArrayList<Figure> figures, Functor functor) {
        ArrayList<Figure> figuresList = new ArrayList<>();
        Figure small = null;
        Figure big = null;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (Figure figure : figures) {
            if (functor == Functor.PERIMETER) {
                if (figure.perimeter() > max) {
                    max = figure.perimeter();
                    big = figure;
                }
                if (figure.perimeter() < min) {
                    min = figure.perimeter();
                    small = figure;
                }
            } else if (functor == Functor.SQUARE) {
                if (figure.square() > max) {
                    max = figure.square();
                    big = figure;
                }
                if (figure.square() < min) {
                    min = figure.square();
                    small = figure;
                }
            }
        }
        figuresList.add(small);
        figuresList.add(big);
        return figuresList;
    }

    /**
     * 1.В классе Repository реализовать метод, принимающий на вход имя текстового файла и множество различных фигур
     * и выполняющий сохранение данного множества в файл figures.csv в следующем формате:
     * название_фигуры;параметры_фигуры_через «;»;площадь;периметр
     */
    public static void toCSV(String name, ArrayList<Figure> figures) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name))) {
            for (com.movsisyan.interfaces.Figure figure : figures) {
                bufferedWriter.write(figure.toCSV());
                bufferedWriter.write("\n");
            }
        }
    }

    /**
     * 2.	Реализовать метод, который принимает на вход имя файла, где сохранено множество различных фигур, объект
     * фигуры, который необходимо заменить в файле и объект фигуры на которую требуется произвести замену.
     * Выполняет замену одной фигуры в файле на другую, используя рациональные алгоритмы решения
     */
    public static void replaceFigure(String name, Figure figure, Figure changedFigure,
                                           Map<String, Fabric> fabric) throws IOException {
        ArrayList<Figure> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            while (bufferedReader.ready()) {
                try {
                    String readLine = bufferedReader.readLine();
                    String[] split = readLine.split(";");
                    String split0 = split[0];
                    Fabric fabric1 = fabric.getOrDefault(split0, null);
                    String[] strings = Arrays.copyOfRange(split, 1, split.length - 2);
                    double[] doubles = new double[strings.length];
                    for (int i = 0; i < strings.length; i++) {
                        doubles[i] = Double.parseDouble(strings[i]);
                    }
                    Figure figure1 = fabric1.newInstance(doubles);
                    list.add(figure1);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
        int i = list.indexOf(figure);
        if (i != -1) {
            list.set(i, changedFigure);
        }
        Repository.toCSV(name, list);
    }
}
