package com.jhonson.service.algotithm.evolution;

import com.jhonson.service.algotithm.fitness.FitnessCalculator;
import com.jhonson.service.algotithm.model.SensorConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SensorCrossover {

    public static List<SensorConfig> performCrossover(SensorConfig parent1, SensorConfig parent2) {
        Random rand = new Random();

        int chance = rand.nextInt(1000);

        if (chance < 700) {
            int placeSize = parent1.getPlaceConfig().length;
            int transitionSize = parent1.getTransConfig().length;

            // Select different crossover points for places and transitions
            int crossoverPointPlaces = rand.nextInt(placeSize);
            int crossoverPointTransitions = rand.nextInt(transitionSize);

            //System.out.println("Punto de cruce lugares: " + crossoverPointPlaces);
            //System.out.println("Punto de cruce transisiones: " + crossoverPointTransitions + "\n");

            // Arrays for offspring configurations
            int[] placesChild1 = new int[placeSize];
            int[] placesChild2 = new int[placeSize];
            int[] transitionsChild1 = new int[transitionSize];
            int[] transitionsChild2 = new int[transitionSize];

            // Crossover for "places"
            for (int i = 0; i < placeSize; i++) {
                if (i < crossoverPointPlaces) {
                    placesChild1[i] = parent1.getPlaceConfig()[i]; // Inherit from Parent 1
                    placesChild2[i] = parent2.getPlaceConfig()[i]; // Inherit from Parent 2
                } else {
                    placesChild1[i] = parent2.getPlaceConfig()[i]; // Swap with Parent 2
                    placesChild2[i] = parent1.getPlaceConfig()[i]; // Swap with Parent 1
                }
            }

            // Crossover for "transitions"
            for (int i = 0; i < transitionSize; i++) {
                if (i < crossoverPointTransitions) {
                    transitionsChild1[i] = parent1.getTransConfig()[i]; // Inherit from Parent 1
                    transitionsChild2[i] = parent2.getTransConfig()[i]; // Inherit from Parent 2
                } else {
                    transitionsChild1[i] = parent2.getTransConfig()[i]; // Swap with Parent 2
                    transitionsChild2[i] = parent1.getTransConfig()[i]; // Swap with Parent 1
                }
            }

            // Create new offspring objects
            SensorConfig child1 = new SensorConfig(placesChild1, transitionsChild1);
            SensorConfig child2 = new SensorConfig(placesChild2, transitionsChild2);

            List<SensorConfig> children = Arrays.asList(child1, child2);
            //System.out.println("Children");
            return FitnessCalculator.evaluatePopulationFitness(children);


        } else {
            //System.out.println("Parents");
            return Arrays.asList(parent1, parent2);
        }

    }

}

