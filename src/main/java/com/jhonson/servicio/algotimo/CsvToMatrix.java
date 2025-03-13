package com.jhonson.servicio.algotimo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToMatrix {
    public static void main(String[] args) {
        String archivoCSV = "datos.csv"; // Ruta del archivo CSV
        String separador = ","; // Ajusta si el delimitador es otro (por ejemplo, ";")

        List<String[]> listaDatos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(separador);
                listaDatos.add(valores);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convertir la lista a una matriz
        String[][] matriz = listaDatos.toArray(new String[0][]);

        // Imprimir la matriz
        for (String[] fila : matriz) {
            for (String dato : fila) {
                System.out.print(dato + " ");
            }
            System.out.println();
        }
    }
}
