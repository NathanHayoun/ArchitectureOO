import java.util.Scanner;

import properties.ShowPropertiesStrategy;

public class ConvertisseurEuro {
	private double montant;
	private ShowPropertiesStrategy sps;

	public ConvertisseurEuro(ShowPropertiesStrategy sps) {
		this.sps = sps;
	}

	public String convertir() {
		getMontant(sps.readProperties("PROMPT_MONTANT", "Amount"));

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
				System.err.println(sps.readProperties("PROMPT_BAD_MONTANT", "Incorrect Value"));
			}
		}
	}

	private Monnaie getQuelDevise() {
		char signe = '*';
		Scanner sc = new Scanner(System.in);
		while (true) {
			boolean bon;
			System.out.println(sps.readProperties("PROMT_CURRENCY", "¥ or $"));
			try {
				signe = sc.nextLine().charAt(0);
				bon = signe == '$' || signe == '¥';

				if (!bon) {
					System.err.println(sps.readProperties("PROMPT_BAD_CURRENCY", "Incorrect currency"));
				} else {
					if (signe == '$') {
						return new Dollar();
					} else {
						return new Yen();
					}
				}
			} catch (Exception e) {
				System.err.println(sps.readProperties("IS_NOT_NUMBER", "Is not a number"));
			}
		}
	}

	public boolean getArret() {
		Scanner sc = new Scanner(System.in);
		char arret = '*';

		while (true) {
			System.out.println(sps.readProperties("PROMPT_CONTINUE", "Type 0 or 1"));

			try {
				arret = sc.nextLine().charAt(0);
			} catch (Exception e) {
				System.err.println(sps.readProperties("BAD_CHARACTERE", "Not 1 or 0"));
			}

			if (arret == '0') {
				return false;
			} else if (arret == '1') {
				return true;
			} else {
				System.err.println(sps.readProperties("BAD_CHARACTERE", "Not 1 or 0"));
			}
		}
	}
}
