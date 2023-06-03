/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ConexionLibrosPrestados {

    FileWriter fileWrite;
    PrintWriter printWrite;

    public ConexionLibrosPrestados() throws IOException {
        fileWrite = new FileWriter("librosPrestados.txt", true);
        printWrite = new PrintWriter(fileWrite);
    }

    public void guardarDatos(String datos) throws IOException {
        printWrite.println(datos);
        printWrite.close();

    }

    public String leerDatos() throws IOException {
        FileReader fileReader = new FileReader("librosPrestados.txt");
        BufferedReader bufEntrada = new BufferedReader(fileReader);
        String datos = "";
        String linea = bufEntrada.readLine();
        while (linea != null) {
            datos += linea + "\n";
            linea = bufEntrada.readLine();
        }
        bufEntrada.close();

        return datos;
    }

    public void removeDatos(String titulo) throws IOException {
        FileReader fileReader = new FileReader("librosPrestados.txt");
        BufferedReader bufEntrada = new BufferedReader(fileReader);
        ArrayList<String> datosNuevos =new ArrayList<>();
        String linea = bufEntrada.readLine();
        int bandera = 0;
        try {
            while (linea != null) {
                String[] datos = linea.split("\n");
                for (int i = 0; i < datos.length; i++) {
                    String dato = datos[i];
                    String[] datosIndividuales = dato.split(";");

                    fin:
                    for (int j = 0; j < datosIndividuales.length; j++) {
                        String datosIndividuale = datosIndividuales[j];
                        if (datosIndividuales[1].equalsIgnoreCase(titulo)) {
                            bandera=0;
                            break fin;
                        } else {
                            bandera = 1;
                        }
                    }
                    if (bandera == 1) {
                        datosNuevos.add(dato);
                    }
                }
                linea = bufEntrada.readLine();
            }
        } catch (Exception e) {
        }
        
        fileWrite = new FileWriter("librosPrestados.txt");
        printWrite = new PrintWriter(fileWrite);
        
        for (int i = 0; i < datosNuevos.size(); i++) {
            String get = datosNuevos.get(i);
            printWrite.println(get);
        }
        
        bufEntrada.close();
        printWrite.close();
    }
}
