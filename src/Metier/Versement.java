package Metier;

public class Versement extends Operation {
    private String source;

    public Versement(double montant, String source) {
        super(montant, "versement");
        this.source = source;
    }
    @Override
    public String getDetails() {
        return source;
    }

    public void faireVersement(Compte compte) {
        compte.setSolde(compte.getSolde() + montant);
        compte.getOperations().add(this);
    }
}
