package Metier;

public abstract class Compte {
    protected String code;
    protected double solde;
    protected ArrayList<Operation> operations;
    protected String type;
    private static int compteur = 1;
}
