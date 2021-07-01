package sockets;

import properties.ShowPropertiesStrategy;

public abstract class BaseSockets {
	protected boolean running;
	protected ShowPropertiesStrategy sps;

	public BaseSockets(ShowPropertiesStrategy sps) {
		this.running = true;
		this.sps = sps;
	}

	public abstract void start();

}
