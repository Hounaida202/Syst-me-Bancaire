package Metier;

public class CompteCourant extends Compte {

    private static final double decouvert = 200;
    public CompteCourant(double solde) {
        super(solde, "Courant");
    }
}
