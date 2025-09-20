package Ui;

import Metier.*;
import util.helper;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Compte> comptes;
    private Scanner scanner;

    public Menu() {
        comptes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix;
        do {
            System.out.println("1-ajouter un compte");
            System.out.println("2-afficher les details d un compte");
            System.out.println("3-faire un retrait");
            System.out.println("4-faire un versement");
            System.out.println("5-faire un virement");
            System.out.println("6-afficher les operations d un compte");
            System.out.println("7-quitter");
            choix = helper.verifierchoix(scanner, 1, 7);
            switch (choix) {
                case 1:
                    ajouterCompte();
                    break;
                case 2:
                    afficherSolde();
                    break;
                case 3:
                    faireRetrait();
                    break;
                case 4:
                    faireVersement();
                    break;
                case 5:
                    faireVirement();
                    break;
                case 6:
                    afficherlesOperations();
                    break;
                case 7:
                    System.out.println("programme exité");
                    break;
            }
        } while (choix != 7);
    }

    private void ajouterCompte() {

        double solde = helper.lireDouble(scanner, "solde  : ");

        System.out.println("Type de compte :");
        System.out.println("tapez 1 pour Compte Courant");
        System.out.println("tapez 2 pour Compte Épargne");
        int type = helper.verifierchoix(scanner, 1, 2);

        Compte compte;
        if (type == 1) {
            compte = new CompteCourant(solde);
        } else {
            compte = new CompteEpargne(solde);
        }

        compte.ajouterCompte(comptes);
        System.out.println("un compte crée avec succes , votre code est : " + compte.getCode());
    }

    private void afficherDetailsCompte() {
        System.out.println("\n afficher les details");

        String code = helper.lireString(scanner, "Code du compte : ");
        Compte compte = trouverCompte(code);
        if (compte != null) {
            compte.afficherDetails();
        } else {
            System.out.println("compte n'existe pas");
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
        System.out.println("\n - effectuer un versement");

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
    private void afficherOperationsCompte() {

        String code = helper.lireString(scanner, "Code du compte : ");
        Compte compte = trouverCompte(code);

        if (compte != null) {
            compte.afficherOperations();
        } else {
            System.out.println("Compte non trouve");
        }
    }

    private void faireVirement() {

        // Compte source
        String codeSource = helper.lireString(scanner, "Code du compte source : ");
        Compte compteSource = trouverCompte(codeSource);

        if (compteSource == null) {
            System.out.println("Compte source non trouvé");
            return;
        }

        // Compte destination
        String codeDest = helper.lireString(scanner, "Code du compte destination : ");
        Compte compteDest = trouverCompte(codeDest);

        if (compteDest == null) {
            System.out.println("Compte destination non trouvé");
            return;
        }

        double montant = helper.lireDouble(scanner, "Montant a envoyer: ");

        Retrait retrait = new Retrait(montant, "Virement vers " + compteDest.getCode());
        boolean retraitReussi = retrait.faireRetrait(compteSource);

        if (retraitReussi) {
            Versement versement = new Versement(montant, "Virement depuis " + compteSource.getCode());
            versement.faireVersement(compteDest);

            System.out.println("Virement reussi ");
        } else {
            System.out.println("Virement impossible ");
        }
    }
}
