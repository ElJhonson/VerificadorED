package com.jhonson.service.algotithm;

import java.util.ArrayList;
import java.util.List;

public class GenesGenerator {

    public static List<SensorConfig> generateGenes(int[][] c) {

        List<SensorConfig> validConfigs  = new ArrayList<>();

        while (validConfigs .size()<100) {

            int[] places =  PlaceTransistionGenerator.generateMeasurablePlaces(c.length);
            int[] transitions = PlaceTransistionGenerator.generateMeasurableTransitions(c[0].length);

            if(EventDetectabilityChecker.checkEventDetectability(c, places, transitions)){
                SensorConfig config = new SensorConfig(places, transitions);
                validConfigs.add(config);
            }
        }

        return validConfigs;
    }
}
