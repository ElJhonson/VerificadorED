package com.jhonson.service.algotithm.fitness;

public class SensorManagerCost {
    public static float[] COST_PLACES;
    public static float[] COST_TRANSITION;

    public static void CostConfig(float[] placeCost, float[] transitionsCost) {
        COST_PLACES = placeCost;
        COST_TRANSITION = transitionsCost;
    }
}
