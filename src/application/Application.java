package application;

import Configuration.Configuration;
import properties.IReadProperties;
import properties.ReadFileProperties;
import properties.ShowPropertiesStrategy;
import sockets.Client;
import sockets.Server;

public class Application {
	public void start() {
		IReadProperties iReadProperties = new ReadFileProperties(Configuration.getPathLanguage());
		ShowPropertiesStrategy sps = new ShowPropertiesStrategy().setPropertiesStrategy(iReadProperties);

		Thread server = new Thread(new Runnable() {

			@Override
			public void run() {
				Server server = new Server();
				server.start();
			}
		});
		server.start();

		Thread client = new Thread(new Runnable() {

			@Override
			public void run() {
				Client client = new Client(sps);
				client.start();
			}
		});
		client.start();
	}
}
