package Metier;

public class Retrait extends Operation{
    private String destination;
    public Retrait(double montant, String destination) {
        super(montant, "retrait");
        this.destination = destination;
    }

    @Override
    public String getDetails() {
        return destination;
    }

    public boolean faireRetrait(Compte compte) {
        double newsolde = compte.getSolde() - montant;
        if (compte instanceof CompteCourant) {
            CompteCourant cc = (CompteCourant) compte;
            if (newsolde >= -cc.getDecouvert()) {
                compte.setSolde(newsolde);
                compte.getOperations().add(this);
                return true;
            }
        } else {

            if (newsolde >= 0) {
                compte.setSolde(newsolde);
                compte.getOperations().add(this);
                return true;
            }
        }
        return false;
    }

}
