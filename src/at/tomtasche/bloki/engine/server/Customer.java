package at.tomtasche.bloki.engine.server;

import javax.persistence.Id;

public class Customer {

    @Id
    String url;
    
    String mail;
    
    
    Customer() {}
    
    public Customer(String url, String mail) {
	this.url = url;
	this.mail = mail;
    }
    
    
    public String getMail() {
	return mail;
    }
    
    public String getUrl() {
	return url;
    }
}
