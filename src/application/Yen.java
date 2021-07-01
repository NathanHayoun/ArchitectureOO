package application;

import properties.ShowPropertiesStrategy;

public class Yen extends Money {
	public final double TAUX = 129.25;

	public Yen(ShowPropertiesStrategy sps) {
		super(sps);
		this.rate = TAUX;
		this.acronym = '¥';
	}
}
