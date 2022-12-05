package org.example;

import java.io.*;
import java.util.*;
public class Main
{
    static void TelepitSzenzorHalozat(String input, EtetoModul etetoModul)
    {
        try {
            File file = new File(input);
            Scanner myReader;
            myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String sor = myReader.nextLine();
                String[] adatok = sor.split(";");
                System.out.println("adatok[0]: " + adatok[0]);
                System.out.println("adatok[1]: " + adatok[1]);
                System.out.println("adatok[2]: " + adatok[2]);
                System.out.println("adatok[3]: " + adatok[3]);
                if (adatok[0].equals("T")) {
                    Eteto tapAdagolo = new TapAdagolo(
                            Integer.parseInt(adatok[1]),
                            Integer.parseInt(adatok[2]),
                            Integer.parseInt(adatok[3]),
                            Integer.parseInt(adatok[4]));
                    etetoModul.telepit(tapAdagolo);
                } else {
                    Eteto vitaminAdagolo = new VitaminAdagolo(
                            Integer.parseInt(adatok[1]),
                            Integer.parseInt(adatok[2]),
                            Formatum.valueOf(adatok[3]));
                    etetoModul.telepit(vitaminAdagolo);
                }
            }
            myReader.close();
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        EtetoModul etetoModul = new EtetoModul();
        TelepitSzenzorHalozat("C:\\Temp\\etetok.csv", etetoModul);

    }
}