package com.jhonson.service.algotithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to check event detectability in a matrix.
 */
public class EventDetectabilityChecker {

    /**
     * Checks if an event is detectable based on the given matrix, states, and transitions.
     *
     * @param matrix      The input matrix.
     * @param states      An array representing the states.
     * @param transitions An array representing the transitions.
     * @return {@code true} if the event is detectable, otherwise {@code false}.
     */
    public static boolean checkEventDetectability(int[][] matrix, int[] states, int[] transitions) {
        int[][] filteredMatrix = removeRowsAndColumns(matrix, states, transitions);

        if (!hasZeroColumns(filteredMatrix)) {
            return !hasDuplicateColumns(filteredMatrix);
        }

        return false;
    }

    /**
     * Checks if the given matrix contains duplicate columns.
     *
     * @param matrix The matrix to check.
     * @return {@code true} if duplicate columns exist, otherwise {@code false}.
     */
    public static boolean hasDuplicateColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int c1 = 0; c1 < cols; c1++) {
            for (int c2 = c1 + 1; c2 < cols; c2++) {
                boolean isDuplicate = true;

                for (int r = 0; r < rows; r++) {
                    if (matrix[r][c1] != matrix[r][c2]) {
                        isDuplicate = false;
                        break;
                    }
                }

                if (isDuplicate) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the given matrix contains columns filled entirely with zeros.
     *
     * @param matrix The matrix to check.
     * @return {@code true} if there is at least one zero column, otherwise {@code false}.
     */
    public static boolean hasZeroColumns(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return true;
        }
        for (int c = 0; c < matrix[0].length; c++) {
            boolean isZeroColumn = true;

            for (int r = 0; r < matrix.length; r++) {
                if (matrix[r][c] != 0) {
                    isZeroColumn = false;
                    break;
                }
            }

            if (isZeroColumn) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes specified rows and columns from the matrix based on the given states and transitions.
     *
     * @param matrix      The input matrix.
     * @param states      Array representing which rows to keep.
     * @param transitions Array representing which columns to keep.
     * @return The filtered matrix after removing unwanted rows and columns.
     */
    public static int[][] removeRowsAndColumns(int[][] matrix, int[] states, int[] transitions) {
        int[][] filteredRows = filterRows(states, matrix).toArray(new int[0][]);

        int rowCount = filteredRows.length;
        int colCount = matrix[0].length;

        List<Integer> validColumns = filterColumns(transitions, colCount);

        int[][] finalMatrix = new int[rowCount][validColumns.size()];

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < validColumns.size(); c++) {
                finalMatrix[r][c] = filteredRows[r][validColumns.get(c)];
            }
        }
        return finalMatrix;
    }

    /**
     * Filters out columns based on the transition array.
     *
     * @param transitions  The transition array indicating which columns to keep.
     * @param totalColumns The total number of columns in the original matrix.
     * @return A list of column indices that should be retained.
     */
    private static List<Integer> filterColumns(int[] transitions, int totalColumns) {
        List<Integer> validColumns = new ArrayList<>();
        for (int c = 0; c < totalColumns; c++) {
            if (transitions[c] == 0) {
                validColumns.add(c);
            }
        }
        return validColumns;
    }

    /**
     * Filters out rows based on the states array.
     *
     * @param states The state array indicating which rows to keep.
     * @param matrix The original matrix.
     * @return A list of retained rows.
     */
    private static List<int[]> filterRows(int[] states, int[][] matrix) {
        List<int[]> filteredRows = new ArrayList<>();

        for (int r = 0; r < states.length; r++) {
            if (states[r] == 1) {
                filteredRows.add(matrix[r]);
            }
        }
        return filteredRows;
    }
}
