package application;

import exception.NegativeNumberException;
import properties.ShowPropertiesStrategy;

public abstract class Money {
	protected double rate;
	protected char acronym;
	protected ShowPropertiesStrategy sps;

	public Money(ShowPropertiesStrategy sps) {
		this.sps = sps;
	}

	public double conversion(double amount) throws NegativeNumberException {
		if (amount < 0) {
			throw new NegativeNumberException(sps.readProperties("NEGATIVE_NUMBER", "Negative number"));
		}
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
