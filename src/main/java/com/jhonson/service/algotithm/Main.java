package com.jhonson.service.algotithm;

public class Main {
    public static void main(String[] args) {

        String CSVPath = "/C://Users//angel//OneDrive//Documentos//Prueba//matriz.csv/";
//
        int[][] c = CsvParser.parseCsvToMatrix(CSVPath, ",");
//
//        MatrizHelper.showMatriz(c);
//

//
//
//        System.out.println("\nplaces");
//        MatrizHelper.showArray(places);
//
//        System.out.println("\nTransitions");
//        MatrizHelper.showArray(transitions);
//
//
//
//        int[][] prueba = EventDetectabilityChecker.removeRowsAndColumns(c, places, transitions);
//
//        System.out.println("\nMatriz recortada");
//        MatrizHelper.showMatriz(prueba);
//
//        System.out.println();
//
//
//        System.out.println(EventDetectabilityChecker.checkEventDetectability(c, places, transitions));

        int[][] test = GenesGenerator.generateGenes(c);

        MatrizHelper.showMatriz(test);

    }
}