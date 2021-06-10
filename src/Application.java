import Configuration.Configuration;
import properties.IReadProperties;
import properties.ReadFileProperties;
import properties.ShowPropertiesStrategy;

public class Application {
	public void start() {
		IReadProperties iReadProperties = new ReadFileProperties(Configuration.getPathLanguage());
		ShowPropertiesStrategy sps = new ShowPropertiesStrategy().setPropertiesStrategy(iReadProperties);
		ConvertisseurEuro convertisseur = new ConvertisseurEuro(sps);
		boolean continu = true;
		while (continu) {
			System.out.println(convertisseur.convertir());
			continu = convertisseur.getArret();
		}
	}
}
