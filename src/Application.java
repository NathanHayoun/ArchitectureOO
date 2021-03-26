public class Application {
    public void start(){
        ConvertisseurEuro convertisseur = new ConvertisseurEuro();
        boolean continu = true;
        while (continu) {
            System.out.println(convertisseur.convertir());
            continu = convertisseur.getArret();
        }
    }
}
