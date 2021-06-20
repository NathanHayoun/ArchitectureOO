package application;

public class Dollar extends Money {
	public final double RATE = 1.18;

	public Dollar() {
		this.rate = RATE;
		this.acronym = '$';
	}
}
