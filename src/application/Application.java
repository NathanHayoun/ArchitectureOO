package application;

import configuration.Configuration;
import properties.IReadProperties;
import properties.ReadFileProperties;
import properties.ShowPropertiesStrategy;
import sockets.BaseSockets;
import sockets.Client;
import sockets.Server;

public class Application {
	public void start() {
		IReadProperties iReadProperties = new ReadFileProperties(Configuration.getPathLanguage());
		ShowPropertiesStrategy sps = ShowPropertiesStrategy.getInstance().setPropertiesStrategy(iReadProperties);

		Thread server = initServer(sps);
		server.start();

		Thread client = initClient(sps);
		client.start();
	}

	public Thread initClient(ShowPropertiesStrategy sps) {
		Thread client = new Thread(new Runnable() {

			@Override
			public void run() {
				BaseSockets client = new Client(sps);
				client.start();
			}
		});
		return client;
	}

	public Thread initServer(ShowPropertiesStrategy sps) {
		Thread server = new Thread(new Runnable() {

			@Override
			public void run() {
				BaseSockets server = new Server(sps);
				server.start();
			}
		});
		return server;
	}
}
