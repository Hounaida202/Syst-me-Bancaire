package Metier;

import java.util.ArrayList;

public class CompteCourant extends Compte {

    private static final double decouvert = 200;
    public CompteCourant(double solde) {
        super(solde, "Courant");
    }

    @Override
    public void ajouterCompte(ArrayList<Compte> comptes) {
        comptes.add(this);
    }
    @Override
    public void afficherDetails() {
        System.out.println("---afficher le solde ");
//        System.out.println("Code: " + code);
        System.out.println("Solde: " + solde + " dh");
//        System.out.println("decouvert: " + decouvert + " dh");
    }
    public double getDecouvert() { return decouvert; }

}
