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


    private void faireRetrait() {
        System.out.println("\n effectuer un retrait");

        String code = helper.lireString(scanner, "Code du compte : ");
        Compte compte = trouverCompte(code);

        if (compte == null) {
            System.out.println("Compte non trouvé ");
            return;
        }

        double montant = helper.lireDouble(scanner, "Montant a retirer : ");
        String destination = helper.lireString(scanner, "Destination : ");

        Retrait retrait = new Retrait(montant, destination);
        boolean reussi = retrait.faireRetrait(compte);

        if (reussi) {
            System.out.println("Retrait effectué. Nouveau solde : " + compte.getSolde() + " dh");
        } else {
            System.out.println(" retrait impossible ");
        }
    }

    private void faireVersement() {
        System.out.println("\n- effectuer un versement");

        String code = helper.lireString(scanner, "Code du compte : ");
        Compte compte = trouverCompte(code);

        if (compte == null) {
            System.out.println("Compte non trouvé ");
            return;
        }
        double montant = helper.lireDouble(scanner, "Montant a verser : ");
        String source = helper.lireString(scanner, "Source : ");
        Versement versement = new Versement(montant, source);
        versement.faireVersement(compte);
        System.out.println("Versement effectue . Nouveau solde : " + compte.getSolde() + " dh");
    }

}