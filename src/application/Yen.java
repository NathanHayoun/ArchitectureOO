package application;

public class Yen extends Money {
	public final double TAUX = 129.25;

	public Yen() {
		this.rate = TAUX;
		this.acronym = '¥';
	}
}
