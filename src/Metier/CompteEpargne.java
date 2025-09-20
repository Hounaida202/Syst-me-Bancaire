package Metier;

import java.util.ArrayList;

public class CompteEpargne extends Compte {

    private static final double taux = 0.2;

    public CompteEpargne(double solde) {
        super(solde, "epargne");
    }

    @Override
    public void ajouterCompte(ArrayList<Compte> comptes) {
        comptes.add(this);
    }
}
