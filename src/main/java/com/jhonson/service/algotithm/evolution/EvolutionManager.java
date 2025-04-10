package com.jhonson.service.algotithm.evolution;

import com.jhonson.service.algotithm.fitness.EventDetectabilityChecker;
import com.jhonson.service.algotithm.fitness.FitnessCalculator;
import com.jhonson.service.algotithm.model.SensorConfig;

import java.util.ArrayList;
import java.util.List;

public class EvolutionManager {

    public static List<List<SensorConfig>> evolveGenerations(int[][] c, int numberOfGenerations){

        List<List<SensorConfig>> allGenerations = new ArrayList<>();

        List<SensorConfig> initialPopulation = GenesGenerator.generateGenes(c);
        List<SensorConfig> evaluatedInitial = FitnessCalculator.evaluatePopulationFitness(initialPopulation);

        allGenerations.add(evaluatedInitial);

        for (int i = 1; i <= numberOfGenerations; i++) {
            List<SensorConfig> nextGen = NextGenerationBuilder(c, allGenerations.get(i-1));
            allGenerations.add(nextGen);
        }

        return allGenerations;
    }


    public static List<SensorConfig> NextGenerationBuilder(int[][] c, List<SensorConfig> currentPopulation){


        List<SensorConfig> nextGeneration = new ArrayList<>();


        SensorConfig sc;
        SensorConfig sc1;

        while (nextGeneration.size()<currentPopulation.size()){

            sc = RouletteSelection.selectRoulette(currentPopulation);
            sc1 = RouletteSelection.selectRoulette(currentPopulation);

            for (SensorConfig Offspring: SensorCrossover.performCrossover(sc, sc1)){
                if(EventDetectabilityChecker.checkEventDetectability(c, Offspring.getPlaceConfig(), Offspring.getTransConfig())){
                    nextGeneration.add(Offspring);
                }
            }

        }


        return nextGeneration;
    }

}
