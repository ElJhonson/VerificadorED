package com.jhonson.service.algotithm;

import com.jhonson.service.algotithm.evolution.EvolutionManager;
import com.jhonson.service.algotithm.fitness.SensorManagerCost;
import com.jhonson.service.algotithm.model.SensorConfig;
import com.jhonson.service.algotithm.util.CsvParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String CSVPath = "/C://Users//angel//OneDrive//Documentos//Prueba//matriz.csv/";
//
        int[][] c = CsvParser.parseCsvToMatrix(CSVPath, ",");
        int[][] d = {
                {-1, 1, 0, 0},
                {1, -1, 1, 0},
                {0, 1, -1, -1},
                {0, 0, 1, -1},
                {-1, 0, 0, 1}
        };
        final float[] COST_PLACES = {1, 1, 1, 1, 1};
        final float[] COST_TRANSITION = {1, 1, 1, 1};

        SensorManagerCost.CostConfig(COST_PLACES, COST_TRANSITION);

        int[] places = {1, 1, 1, 0, 1};
        int[] transition = {1, 1, 1, 1};


        for (List<SensorConfig> scf: EvolutionManager.evolveGenerations(d, 3)){
            System.out.println("========================Generation=============================");
            for (SensorConfig s: scf){
                System.out.println(s);
            }

        }

    }
}