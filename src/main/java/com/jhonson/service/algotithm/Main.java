package com.jhonson.service.algotithm;

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

        int[] places = {1, 1, 1, 0, 1};
        int[] transition = {1, 1, 1, 1};

        FitnessCalculator.evaluatePopulationFitness(d, COST_PLACES, COST_TRANSITION);

    }
}