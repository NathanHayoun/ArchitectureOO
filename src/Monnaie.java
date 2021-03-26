public abstract class Monnaie {
    protected double taux;
    protected char sigle;
    protected double conversion(double montant) {
        montant = montant * taux;
        return (double)Math.round(montant * 100) / 100;
    }
}
