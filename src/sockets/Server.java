package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import exception.NegativeNumberException;
import model.Dollar;
import model.Money;
import model.Yen;
import properties.ShowPropertiesStrategy;

public class Server extends BaseSockets {
	private double amount;

	public Server(ShowPropertiesStrategy sps) {
		super(sps);
	}

	@Override
	public void start() {

		final ServerSocket serveurSocket;
		final Socket clientSocket;

		try {
			serveurSocket = new ServerSocket(5000);
			clientSocket = serveurSocket.accept();
			Thread receive = new Thread(new Runnable() {
				public void stop() {
					running = false;
				}

				@Override
				public void run() {
					while (running) {
						try {
							ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
							Enveloppe envelop = (Enveloppe) ois.readObject();

							try {
								double amountTypeByUser = Double.valueOf(envelop.getMessage());
								amount = amountTypeByUser;
								envelop.setDateResponse(System.currentTimeMillis())
										.setReferenceServeur(serveurSocket.getLocalSocketAddress().toString())
										.setResponse("sigle");
								ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
								oos.writeObject(envelop);
							} catch (Exception e) {
								System.err.println(e);
								break;
							}
							ois = new ObjectInputStream(clientSocket.getInputStream());
							envelop = (Enveloppe) ois.readObject();
							Money money = null;

							switch (envelop.getMessage().charAt(0)) {
							case '$':
								money = new Dollar();
								break;
							case '¥':
								money = new Yen();
								break;
							}
							String stringReturn = "";
							EnveloppeStatusReturn status = EnveloppeStatusReturn.ok;

							try {
								stringReturn = String.valueOf(money.conversion(amount)) + money.getAcronym();
							} catch (NegativeNumberException e) {
								System.err.print(sps.readProperties("NEGATIVE_NUMBER", "Negative number") + e);
								status = EnveloppeStatusReturn.erreur;
							}
							envelop.setDateResponse(System.currentTimeMillis())
									.setReferenceServeur(serveurSocket.getLocalSocketAddress().toString())
									.setResponse(stringReturn).setStatus(status);
							;
							ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
							oos.writeObject(envelop);

							ois = new ObjectInputStream(clientSocket.getInputStream());
							envelop = (Enveloppe) ois.readObject();

							if (envelop.getMessage().equals("false")) {
								stop();
							}

						} catch (ClassNotFoundException | IOException e) {
							e.printStackTrace();
						}
					}
				}
			});
			receive.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}