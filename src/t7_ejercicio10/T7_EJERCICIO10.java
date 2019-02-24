/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t7_ejercicio10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class T7_EJERCICIO10 {

    public static boolean esVocal(char letra) {
        boolean loes = false;

        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'
                || letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
            loes = true;
        }

        return loes;
    }

    public static String cambiarVocalesMayuscula(String frase) {
        String frasenueva = "";

        for (int i = 0; i < frase.length(); i++) {
            if (esVocal(frase.charAt(i))) {
                String vocalnueva = "" + frase.charAt(i);
                frasenueva += vocalnueva.toUpperCase();
            } else {
                frasenueva += frase.charAt(i);
            }
        }

        return frasenueva;
    }

    public static String cambiarConsonantesMinuscula(String frase) {
        String frasenueva = "";

        for (int i = 0; i < frase.length(); i++) {
            if (!esVocal(frase.charAt(i))) {
                String vocalnueva = "" + frase.charAt(i);
                frasenueva += vocalnueva.toLowerCase();
            } else {
                frasenueva += frase.charAt(i);
            }
        }

        return frasenueva;
    }

    public static void main(String[] args) {
        Scanner tecladostring = new Scanner(System.in);

        String ficheroleer, ficheroescribir;

        File leer = null;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter escribir = null;
        PrintWriter pw = null;

        System.out.println("Dime el fichero de leer (Le he puesto documento.txt)");
        ficheroleer = tecladostring.nextLine();
        System.out.println("Dime el fichero de escribir");
        ficheroescribir = tecladostring.nextLine();

        try {
            // Abro los flujos de lectura
            leer = new File(ficheroleer);
            fr = new FileReader(leer);
            br = new BufferedReader(fr);

            // Abro los flujos de escritura
            escribir = new FileWriter(ficheroescribir);
            pw = new PrintWriter(escribir);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = cambiarVocalesMayuscula(linea);
                linea = cambiarConsonantesMinuscula(linea);
                // Escribo en el fichero
                pw.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.toString());
        } finally {
            // Cerramos los ficheros
            try {
                fr.close();
                escribir.close();
            } catch (IOException e2) {
                System.out.println("Error cerrando el fichero: " + e2.toString());
            }
        }
    }

}
