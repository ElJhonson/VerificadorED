package com.jhonson.service.algotithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Class responsible for calculating the fitness function for a population of sensor configurations.
 * In the context of Petri Nets, it calculates the cost of places and transitions based on the number of sensors
 * and their respective costs.
 */
public class FitnessCalculator {

    /**
     * Evaluates the fitness function for a population of sensor configurations.
     * Each configuration has a distribution of sensors in places and transitions, and the total cost is calculated.
     *
     * @param population A  SensorConfig list representing the actual population.
     * @param placeCosts An array of costs for the places in the Petri net.
     * @param transitionCosts An array of costs for the transitions in the Petri net.
     */
    public static void evaluatePopulationFitness(List<SensorConfig> population, float[] placeCosts, float[] transitionCosts) {
        List<Float> fitnessValues = new ArrayList<>();

        population.forEach(config -> {
            // Calculate the fitness for each configuration and store it in the list.
            float fitness = computeFitness(config, placeCosts, transitionCosts);
            config.setFitness(fitness);
            fitnessValues.add(fitness);
        });

        // Print out the fitness values for the entire population.
        Collections.sort(population);
        AtomicInteger cont = new AtomicInteger();
        SensorConfig conf = Collections.min(population);
        float min = conf.getFitness();
        System.out.println("Min value = "+ min);
        System.out.println("-------------------------------------");
        population.forEach(n ->{
            if (n.getFitness()==min){
                cont.getAndIncrement();
                System.out.println(n);
            }
        });
        System.out.println("Total: "+cont);
        System.out.println("=====================================");
        population.forEach(System.out::println);
    }

    /**
     * Computes the fitness for a single sensor configuration.
     * The fitness is calculated based on the number of sensors in places and transitions,
     * and their respective costs.
     *
     * @param config The sensor configuration to evaluate.
     * @param placeCosts An array of costs for the places in the Petri net.
     * @param transitionCosts An array of costs for the transitions in the Petri net.
     * @return The fitness value as a float.
     */
    public static float computeFitness(SensorConfig config, float[] placeCosts, float[] transitionCosts) {
        int[] placeConfig = config.getPlaceConfig();
        int[] transitionConfig = config.getTransConfig();

        // Calculate the total cost for the places.
        double totalPlaceCost = IntStream.range(0, placeConfig.length)
                .mapToDouble(i -> placeConfig[i] * placeCosts[i])
                .sum();

        // Calculate the total cost for the transitions.
        double totalTransitionCost = IntStream.range(0, transitionConfig.length)
                .mapToDouble(i -> transitionConfig[i] * transitionCosts[i])
                .sum();

        // Return the total fitness (sum of place and transition costs).
        return (float) (totalPlaceCost + totalTransitionCost);
    }
}
