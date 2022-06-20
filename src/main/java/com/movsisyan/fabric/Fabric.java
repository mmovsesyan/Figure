package com.movsisyan.fabric;

import com.movsisyan.interfaces.Figure;

public interface Fabric {
    Figure newInstance(double... args);
}
