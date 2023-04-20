package org.p3.adc.Interfaces;

import org.p3.adc.Constructores.Table;
import org.p3.adc.Excepciones.ClusterException;

import java.util.List;

public interface Algorithm<T extends Table> {
    void train(T datos) throws ClusterException;
    Integer estimate(List<Double> dato);
}
