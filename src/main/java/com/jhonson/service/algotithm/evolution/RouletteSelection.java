package com.jhonson.service.algotithm.evolution;

import com.jhonson.service.algotithm.model.SensorConfig;

import java.util.List;
import java.util.Random;


public class RouletteSelection {

    public static SensorConfig selectRoulette(List<SensorConfig> sensors) {
        int n = sensors.size();
        double totalInverseFitness = 0;
        double[] probabilities = new double[n];

        // Encontrar el fitness mínimo y máximo
        double minFitness = sensors.stream().mapToDouble(SensorConfig::getFitness).min().orElse(1.0);
        double maxFitness = sensors.stream().mapToDouble(SensorConfig::getFitness).max().orElse(1.0);

        // Ajuste exponencial para dar más diferencia a los valores bajos
        for (int i = 0; i < n; i++) {
            double fitness = sensors.get(i).getFitness();
            probabilities[i] = Math.pow(maxFitness / fitness, 2); // Ajuste exponencial
            totalInverseFitness += probabilities[i];
        }

        // Normalizar dividiendo por la suma total
        for (int i = 0; i < n; i++) {
            probabilities[i] /= totalInverseFitness;
        }

        // Crear la ruleta acumulativa
        double[] cumulative = new double[n];
        cumulative[0] = probabilities[0];
        for (int i = 1; i < n; i++) {
            cumulative[i] = cumulative[i - 1] + probabilities[i];
        }

        // Generar número aleatorio entre 0 y 1
        Random rand = new Random();
        double rnd = rand.nextDouble();

        // Buscar en qué rango cae
        for (int i = 0; i < n; i++) {
            if (rnd <= cumulative[i]) {
                return sensors.get(i);
            }
        }

        return sensors.get(n - 1); // Como fallback, retorna el último
    }


}
