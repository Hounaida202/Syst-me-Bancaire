package util;


import java.util.Scanner;

public class helper {

    public static int verifierchoix(Scanner scanner) {
        int choix;
        while (true) {
            System.out.print("Choix entre 1 et 7: ");
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine();
                if (choix >= 1 && choix <= 7) {
                    return choix;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("choix invalide");
        }
    }
}