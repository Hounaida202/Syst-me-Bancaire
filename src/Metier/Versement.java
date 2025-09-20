package Metier;

public class Versement extends Operation {
    private String source;

    public Versement(double montant, String source) {
        super(montant, "versement");
        this.source = source;
    }
}
