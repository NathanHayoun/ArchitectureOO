package sockets;

import java.io.Serializable;

public class Enveloppe implements Serializable {

	private static final long serialVersionUID = -8150939444306339292L;
	private String message;
	private String response;
	private long dateRequests;
	private long dateResponse;
	private String referenceClient;
	private String referenceServer;

	public Enveloppe(String message) {
		this.message = message;
		this.dateRequests = System.currentTimeMillis();
	}

	public String getMessage() {
		return message;
	}

	public Enveloppe setMessage(String message) {
		this.message = message;

		return this;
	}

	public String getResponse() {
		return response;
	}

	public Enveloppe setResponse(String reponse) {
		this.response = reponse;

		return this;
	}

	public long getDateRequest() {
		return dateRequests;
	}

	public Enveloppe setDateRequest(long dateRequetes) {
		this.dateRequests = dateRequetes;

		return this;
	}

	public long getDateResponse() {
		return dateResponse;
	}

	public Enveloppe setDateResponse(long dateReponse) {
		this.dateResponse = dateReponse;

		return this;
	}

	public String getReferenceClient() {
		return referenceClient;
	}

	public Enveloppe setReferenceClient(String referenceClient) {
		this.referenceClient = referenceClient;

		return this;
	}

	public String getReferenceServeur() {
		return referenceServer;
	}

	public Enveloppe setReferenceServeur(String referenceServeur) {
		this.referenceServer = referenceServeur;

		return this;
	}

	@Override
	public String toString() {
		return "Enveloppe [message=" + message + ", response=" + response + ", dateRequest=" + dateRequests
				+ ", dateResponse=" + dateResponse + ", referenceClient=" + referenceClient + ", referenceServeur="
				+ referenceServer + "]";
	}

}
