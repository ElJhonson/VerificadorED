package com.jhonson.service.algotithm;

import java.util.Arrays;

/**
 * Utility class for displaying matrices and arrays in a readable format.
 */
public class MatrizHelper {

    /**
     * Prints a 2D matrix to the console in a structured format.
     * Each row is printed on a new line, and elements are separated by spaces.
     *
     * @param matrix The 2D integer matrix to be displayed.
     */
    public static void showMatriz(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Prints a 1D array to the console in a formatted string representation.
     *
     * @param array The integer array to be displayed.
     */
    public static void showArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}

