package Metier;

import java.time.LocalDateTime;

public abstract class Operation {

    protected int numero;
    protected LocalDateTime date;
    protected double montant;
    protected String type;
    private static int compteur = 1;
}
