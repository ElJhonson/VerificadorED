package com.jhonson.servicio.algotimo;

import java.util.ArrayList;
import java.util.List;

public class VerificadorED {


    public static boolean verificadordeEventoDetectabilidad(int[] estados, int[] transiciones, int[][] c){
        if (!hayColumnasCero(estados, transiciones, c)){
            return !hayColumnasRepetidas(estados, transiciones, c);
        }

        return false;
    }



    public static boolean hayColumnasRepetidas(int[] estados, int[] transiciones, int[][] c) {
        int[][] matriz = eliminarFilasYColumnas(estados, transiciones, c);

        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int col1 = 0; col1 < columnas; col1++) {
            for (int col2 = col1 + 1; col2 < columnas; col2++) {
                boolean columnaRepetida = true;

                for (int fila = 0; fila < filas; fila++) {
                    if (matriz[fila][col1] != matriz[fila][col2]) {
                        columnaRepetida = false;
                        break;
                    }
                }

                if (columnaRepetida) {
                    return true;
                }
            }
        }

        return false;
    }


    public static boolean hayColumnasCero(int[] estados, int[] transiciones, int[][] c) {

        int[][] matriz = eliminarFilasYColumnas(estados, transiciones, c);


        for (int i = 0; i < matriz.length; i++) {
            boolean columnaCero = true;

            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[j][i] != 0) {
                    columnaCero = false;
                    break;
                }
            }

            if (columnaCero) {
                return true;
            }
        }

        return false;
    }

    public static int[][] eliminarFilasYColumnas(int[] estados, int[] transiciones, int[][] c) {

        int[][] filasFiltradas = filtrarFilas(estados, c).toArray(new int[0][]);

        int filas = filasFiltradas.length;
        int columnas = c[0].length;

        List<Integer> columnasValidas = filtrarColumnas(transiciones, columnas);

        int[][] matrizFinal = new int[filas][columnasValidas.size()];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnasValidas.size(); j++) {
                matrizFinal[i][j] = filasFiltradas[i][columnasValidas.get(j)];
            }
        }

        return matrizFinal;
    }


    private static List<Integer> filtrarColumnas(int[] transiciones, int columnas) {
        List<Integer> columnasValidas = new ArrayList<>();
        for (int j = 0; j < columnas; j++) {
            if (transiciones[j] == 0) {
                columnasValidas.add(j);
            }
        }
        return columnasValidas;
    }

    private static List<int[]> filtrarFilas(int[] estados, int[][] c) {
        List<int[]> filasFiltradas = new ArrayList<>();

        for (int i = 0; i < estados.length; i++) {
            if (estados[i] == 1) {
                filasFiltradas.add(c[i]);
            }
        }

        return filasFiltradas;
    }
}
