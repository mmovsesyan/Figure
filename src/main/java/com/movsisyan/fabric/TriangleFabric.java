package com.movsisyan.fabric;

import com.movsisyan.interfaces.Figure;
import com.movsisyan.model.Triangle;

public class TriangleFabric implements Fabric{
    @Override
    public Figure newInstance(double... args) {
        return new Triangle(args[0], args[1], args[2]);
    }
}
