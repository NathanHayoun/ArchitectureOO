package application;

import properties.ShowPropertiesStrategy;

public class Dollar extends Money {
	public final double RATE = 1.18;

	public Dollar(ShowPropertiesStrategy sps) {
		super(sps);
		this.rate = RATE;
		this.acronym = '$';
	}
}
