package com.jhonson.service.algotithm;

public class Main {
    public static void main(String[] args) {
        String CSVPath = "/C://Users//angel//OneDrive//Documentos//Prueba//prueba.csv/";

        int[][] c = CsvParser.parseCsvToMatrix(CSVPath, ",");

        int[][] d = { //resultado esperado
                {-1, 1, 0},
                {0, 1, -1},
                {0, 0, -1},

        };

        for (int[] fila: c){
            for (int columna: fila){
                System.out.print(columna + " ");
            }
            System.out.println();
        }

        int[] states = {1, 0, 1, 1, 0};
        int[] transitions = {0, 0, 1, 0};


        int[][] prueba = EventDetectabilityChecker.removeRowsAndColumns(c, states, transitions);


        System.out.println(EventDetectabilityChecker.checkEventDetectability(c, states, transitions));
    }
}