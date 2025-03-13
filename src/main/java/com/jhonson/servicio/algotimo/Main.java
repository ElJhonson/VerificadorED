package com.jhonson.servicio.algotimo;

public class Main {
    public static void main(String[] args) {
        int[][] c = {
                {-1, -1, 0, 0},
                {1, -1, 1, 0},
                {0, 0, -1, -1},
                {0, 0, 1, -1},
                {-1, 0, 0, 1}
        };

        int[][] d = { //resultado esperado
                {-1, 1, 0},
                {0, 1, -1},
                {0, 0, -1},

        };

        int[] estados = {1, 0, 1, 1, 0};
        int[] transiciones = {0, 0, 1, 0};


        //boolean esCero = VerificadorED.hayColumnasCero(estados, transiciones, c);
        //System.out.println(esCero);

        int[][] prueba = VerificadorED.eliminarFilasYColumnas(c, estados, transiciones);
        for (int i = 0; i < prueba.length; i++) {
            for (int j = 0; j < prueba[i].length; j++) {
                System.out.print(prueba[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(VerificadorED.verificadordeEventoDetectabilidad(c, estados, transiciones));
    }
}