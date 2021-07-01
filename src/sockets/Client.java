package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import properties.ShowPropertiesStrategy;

public class Client extends BaseSockets {

	public Client(ShowPropertiesStrategy sps) {
		super(sps);
	}

	@Override
	public void start() {

		final Socket clientSocket;

		try {
			clientSocket = new Socket("127.0.0.1", 5000);

			Thread reception = new Thread(new Runnable() {
				public void stop() { // Méthode 2
					running = false;
				}

				@Override
				public void run() {
					while (running) {
						try {
							Enveloppe amount = new Enveloppe(getAmount(sps.readProperties("PROMPT_MONTANT", "Amount")));
							ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
							oos.writeObject(amount);

							ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
							Enveloppe envelop = (Enveloppe) ois.readObject();

							oos = new ObjectOutputStream(clientSocket.getOutputStream());
							Enveloppe currency = new Enveloppe(getCurrency());
							oos.writeObject(currency);

							ois = new ObjectInputStream(clientSocket.getInputStream());
							envelop = (Enveloppe) ois.readObject();
							System.out.println(envelop.getResponse());

							oos = new ObjectOutputStream(clientSocket.getOutputStream());
							Enveloppe stop = new Enveloppe(getStop());
							oos.writeObject(stop);
							if (stop.getMessage().equals("false")) {
								stop();
							}
						} catch (ClassNotFoundException | IOException e) {
							e.printStackTrace();
						}
					}
				}
			});
			reception.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getAmount(String s) {
		Scanner sc;
		while (true) {
			System.out.println(s);

			try {
				sc = new Scanner(System.in);
				double amountEnterByUser = sc.nextDouble();
				sc.nextLine();

				if (amountEnterByUser > 0) {
					return String.valueOf(amountEnterByUser);
				} else {
					System.err.println(sps.readProperties("NEGATIVE_NUMBER", "Negative number"));
				}
			} catch (Exception e) {
				System.err.println(sps.readProperties("PROMPT_BAD_MONTANT", "Incorrect Value"));
			}
		}
	}

	private String getCurrency() {
		char currencyTypeByUser = '*';
		Scanner sc = new Scanner(System.in);

		while (true) {
			boolean goodCurrency;
			System.out.println(sps.readProperties("PROMT_CURRENCY", "¥ or $"));

			try {
				currencyTypeByUser = sc.nextLine().charAt(0);
				goodCurrency = currencyTypeByUser == '$' || currencyTypeByUser == '¥';

				if (!goodCurrency) {
					System.err.println(sps.readProperties("PROMPT_BAD_CURRENCY", "Incorrect currency"));
				} else {
					if (currencyTypeByUser == '$') {

						return "$";
					} else {

						return "¥";
					}
				}
			} catch (Exception e) {
				System.err.println(sps.readProperties("IS_NOT_NUMBER", "Is not a number"));
			}
		}
	}

	public String getStop() {
		Scanner sc = new Scanner(System.in);
		char stopTypeByUser = '*';

		while (true) {
			System.out.println(sps.readProperties("PROMPT_CONTINUE", "Type 0 or 1"));

			try {
				stopTypeByUser = sc.nextLine().charAt(0);
			} catch (Exception e) {
				System.err.println(sps.readProperties("BAD_CHARACTERE", "Not 1 or 0"));
			}

			if (stopTypeByUser == '0') {

				return "false";
			} else if (stopTypeByUser == '1') {

				return "true";
			} else {
				System.err.println(sps.readProperties("BAD_CHARACTERE", "Not 1 or 0"));
			}
		}
	}
}