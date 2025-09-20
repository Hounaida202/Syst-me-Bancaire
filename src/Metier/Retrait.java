package Metier;

public class Retrait extends Operation{
    private String destination;
    public Retrait(double montant, String destination) {
        super(montant, "retrait");
        this.destination = destination;
    }

}
