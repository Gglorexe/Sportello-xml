/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltocsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author spinelli_loris
 */
public class WriteCsv {
    public static void SalvaSuFile(String s) throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("circolariSportello.csv", true))) {
            writer.write(s);
        }
    }

    public void SalvaSuFile(String nomeFile, String s) throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile + ".csv", true))) {
            writer.write(s);
        }
    }

    public static String LeggiDaFile() throws FileNotFoundException, IOException {
        String s = "";

        BufferedReader file
                = new BufferedReader(new FileReader("login.csv"));

        String riga = file.readLine();
        while (riga != null) {
            s += riga;
            riga = file.readLine();
        }
        return s;
    }

    //Legge da file
    public String LeggiDaFile(String nomeFile) throws FileNotFoundException, IOException {
        String s = "";

        BufferedReader file
                = new BufferedReader(new FileReader(nomeFile + ".csv"));

        String riga = file.readLine();
        while (riga != null) {

            s += riga;
            riga = file.readLine();
        }

        return s;
    }

    public void CSVtoList(String nomeFile, List<String> array) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile + ".csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                for (int i = 0; i < values.length; i++) {
                    array.add(values[i]);
                } 
            }
        } catch (IOException ex) {
            Logger.getLogger(xmltocsv.WriteCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void SovrascriviFile(String s) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("circolariSportello.csv"))) {
            writer.write(s);
        }
    }

    public void SovrascriviFile(String nomeFile, String s) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile + ".csv"))) {
            writer.write(s);
        }
    }
}
