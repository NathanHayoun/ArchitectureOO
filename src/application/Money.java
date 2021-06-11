package application;

public abstract class Money {
	protected double rate;
	protected char acronym;

	public double conversion(double amount) {
		amount = amount * rate;
		return (double) Math.round(amount * 100) / 100;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double taux) {
		this.rate = taux;
	}

	public char getAcronym() {
		return acronym;
	}

	public void setAcronym(char sigle) {
		this.acronym = sigle;
	}

}
