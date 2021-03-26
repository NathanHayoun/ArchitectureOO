import java.util.Scanner;

public class ConvertisseurEuro {
    private double montant;

    public ConvertisseurEuro() {
    }

    public String convertir() {
        getMontant("Entrer un montant");
        Monnaie monnaie = getQuelDevise();
        return String.valueOf(monnaie.conversion(montant)) + monnaie.sigle;
    }

    private void getMontant(String s) {
        Scanner sc;
        boolean bon = false;

        while (true) {
            System.out.println(s);

            try {
                sc = new Scanner(System.in);
                double nb = sc.nextDouble();
                sc.nextLine();
                this.montant = nb;
                break;
            } catch (Exception e) {
                System.err.println("Montant invalide");
            }
        }
    }

    private Monnaie getQuelDevise() {
        char signe = '*';
        Scanner sc = new Scanner(System.in);
        while (true) {
            boolean bon;
            System.out.println("Choisir une devise ¥ ou $");
            try {
                signe = sc.nextLine().charAt(0);
                bon = signe == '$' || signe == '¥';

                if (!bon) {
                    System.err.println("Devise invalide");
                } else {
                    if (signe == '$') {
                        return new Dollar();
                    } else {
                        return new Yen();
                    }
                }
            } catch (Exception e) {
                System.err.println("Ceci n'est pas un nombre");
            }
        }
    }

    public boolean getArret() {
        Scanner sc = new Scanner(System.in);
        char arret = '*';

        while (true) {
            System.out.println("Saisir 0 pour arreter ou 1 pour continuer");

            try {
                arret = sc.nextLine().charAt(0);
            } catch (Exception e) {
                System.err.println("Mauvais caractère saisi");
            }

            if (arret == '0') {
                return false;
            } else if (arret == '1') {
                return true;
            } else {
                System.err.println("Mauvais caractère saisi");
            }
        }
    }
}
