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
                    afficherDetailsCompte();
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
                    afficherOperationsCompte();
                    break;
                case 7:
                    System.out.println("programme exité");
                    break;
            }
        } while (choix != 7);
    }
}
