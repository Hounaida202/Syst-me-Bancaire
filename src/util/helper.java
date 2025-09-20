package util;


import Metier.Compte;
import Metier.Retrait;
import Metier.Versement;

import java.util.Scanner;

public class helper {

    public static int verifierchoix(Scanner scanner, int min, int max) {
        int choix;
        while (true) {
            System.out.print("Choix : ");
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine();
                if (choix >= min && choix <= max) {
                    return choix;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("choix invalide");
        }
    }

    public static double lireDouble(Scanner scanner, String message) {
        double valeur;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                valeur = scanner.nextDouble();
                scanner.nextLine();
                if (valeur >= -200) {
                    return valeur;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("montant non autorisée ");
        }
    }



}