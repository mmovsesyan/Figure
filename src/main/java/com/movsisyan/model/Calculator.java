package com.movsisyan.model;

import com.movsisyan.enums.Functor;
import com.movsisyan.interfaces.Figure;

public class Calculator {
    private Figure figure;

    public Calculator(Figure figure) {
        this.figure = figure;
    }

    public double calculate(Functor functor) {
        String name = functor.name();
        if (functor == Functor.SQUARE) {
            return figure.square();
        }
        return figure.perimeter();
    }
}
