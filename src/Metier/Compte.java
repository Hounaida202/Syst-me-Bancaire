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
    public abstract void afficherDetails();

    public String getCode() { return code; }
    public double getSolde() { return solde; }
    public ArrayList<Operation> getOperations() { return operations; }

    public void setSolde(double solde) { this.solde = solde; }
    public void setOperations(ArrayList<Operation> operations) { this.operations = operations; }

}
