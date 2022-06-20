package com.movsisyan.fabric;

import com.movsisyan.interfaces.Figure;
import com.movsisyan.model.Rectangle;

public class RectangleFabric implements Fabric{
    @Override
    public Figure newInstance(double... args) {
        return new Rectangle(args[0], args[1]);
    }
}
