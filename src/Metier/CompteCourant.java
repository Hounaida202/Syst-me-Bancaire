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
}
