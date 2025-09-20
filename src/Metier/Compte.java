package Metier;

import java.util.ArrayList;

public abstract class Compte {
    protected String code;
    protected double solde;
    protected ArrayList<Operation> operations;
    protected String type;
    private static int compteur = 1;

    public Compte(double solde, String type) {
        this.code = "CPT-" + String.format("%05d", compteur++);
        this.solde = solde;
        this.operations = new ArrayList<>();
        this.type = type;
    }
    public abstract void ajouterCompte(ArrayList<Compte> comptes);

}
