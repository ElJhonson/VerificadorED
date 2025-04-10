package com.jhonson.service.algotithm.model;

import java.util.Arrays;

public class SensorConfig implements Comparable<SensorConfig>{
    private int[] placeConfig;
    private int[] transConfig;
    private float fitness;

    public SensorConfig() {
    }

    public SensorConfig(int[] placeConfig, int[] transConfig) {
        this.placeConfig = placeConfig;
        this.transConfig = transConfig;
    }

    public int[] getPlaceConfig() {
        return placeConfig;
    }

    public void setPlaceConfig(int[] placeConfig) {
        this.placeConfig = placeConfig;
    }

    public int[] getTransConfig() {
        return transConfig;
    }

    public void setTransConfig(int[] transConfig) {
        this.transConfig = transConfig;
    }

    public float getFitness() {
        return fitness;
    }

    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        return "placeConfig: " + Arrays.toString(placeConfig) +
                "\ntransConfig: " + Arrays.toString(transConfig) +
                "\nfitness: "+fitness;
    }


    @Override
    public int compareTo(SensorConfig o) {
        return Float.compare(this.fitness, o.fitness);
    }

}
