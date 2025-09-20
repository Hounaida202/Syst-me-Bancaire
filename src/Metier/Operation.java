package Metier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Operation {

    protected int numero;
    protected LocalDateTime date;
    protected double montant;
    protected String type;
    private static int compteur = 1;

    public Operation(double montant, String type) {
        this.numero = compteur++;
        this.date = LocalDateTime.now();
        this.montant = montant;
        this.type = type;
    }
    public abstract String getDetails();

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return type + " - " + montant + " dh - " + date.format(formatter) + " - " + getDetails();
    }
}
