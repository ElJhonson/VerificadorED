package com.jhonson.service.algotithm;

public class Main {
    public static void main(String[] args) {
        String CSVPath = "/C://Users//angel//OneDrive//Documentos//Prueba//prueba.csv/";

        int[][] c = CsvParser.parseCsvToMatrix(CSVPath, ",");

        int[][] d = { //Matriz parseada
                {-1, -1, 0, 0},
                {1, -1, 1, 0},
                {0, 0, -1, -1},
                {0, 0, 1, -1},
                {-1, 0, 0, 1}
        };

        MatrizHelper.showMatriz(c);

        int[] places = {0, 1, 0, 1, 0};
        int[] transitions = {1, 1, 1, 1};


        System.out.println("\nplaces");
        MatrizHelper.showArray(places);

        System.out.println("\nTransitions");
        MatrizHelper.showArray(transitions);



        int[][] prueba = EventDetectabilityChecker.removeRowsAndColumns(c, places, transitions);

        System.out.println("\nMatriz");
        for (int[] fila: prueba){
            for (int columna: fila){
                System.out.print(columna + " ");
            }
            System.out.println();
        }

        System.out.println();


        System.out.println(EventDetectabilityChecker.checkEventDetectability(c, places, transitions));
    }
}