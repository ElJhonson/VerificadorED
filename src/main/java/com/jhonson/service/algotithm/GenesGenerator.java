package com.jhonson.service.algotithm;

import java.util.ArrayList;
import java.util.List;

public class GenesGenerator {

    public static int[][] generateGenes(int[][] c) {

        List<int[]> validGenes  = new ArrayList<>();

        while (validGenes .size()<100) {
            int[] places =  PlaceTransistionGenerator.generateMeasurablePlaces(c.length);
            int[] transitions = PlaceTransistionGenerator.generateMeasurableTransitions(c[0].length);

            if(EventDetectabilityChecker.checkEventDetectability(c, places, transitions)){
                validGenes .add(places);
                validGenes .add(transitions);
            }
        }

        return validGenes.toArray(new int[0][]);
    }
}
