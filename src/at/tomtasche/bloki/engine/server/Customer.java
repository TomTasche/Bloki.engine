package at.tomtasche.bloki.engine.server;

import javax.persistence.Id;

public class Customer {

	@Id
	String url;

	String mail;

	Customer() {
	}

	public Customer(final String url, final String mail) {
		this.url = url;
		this.mail = mail;
	}

	public String getMail() {
		return this.mail;
	}

	public String getUrl() {
		return this.url;
	}
}
