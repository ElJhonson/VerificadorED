package com.jhonson.service.algotithm;

import java.util.Random;

public class PlaceTransitionGenerator {

    private static Random random = new Random();

    public static int[] generateMeasurablePlaces(int rows){

        int[] states = new int[rows];

        for (int r = 0; r < rows; r++){
            states[r] = random.nextInt(2);
        }

        return states;
    }

    public static int[] generateMeasurableTransitions(int columns){

        int[] transitions = new int[columns];

        for (int c = 0; c < columns; c++){
            transitions[c] = random.nextInt(2);
        }

        return transitions;
    }
}
