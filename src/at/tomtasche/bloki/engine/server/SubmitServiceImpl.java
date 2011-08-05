package at.tomtasche.bloki.engine.server;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import at.tomtasche.bloki.engine.client.SubmitService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SubmitServiceImpl extends RemoteServiceServlet implements SubmitService {

    public String submit(String mistake, String correction, String url) throws IllegalArgumentException {
	// Escape data from the client to avoid cross-site script vulnerabilities.
	url = escapeHtml(url);
	mistake = escapeHtml(mistake);
	correction = escapeHtml(correction);
	
	BlokiPacket packet = new BlokiPacket(mistake, correction, url);

	String body = buildMessage(packet);

	try {
	    Customer customer = getCustomer(packet);
	    if (customer == null) {
		customer = new Customer(new URL(packet.getUrl()).getHost(), "tomtasche+bloki@gmail.com");
	    }

	    sendMail(customer, packet, body);
	    
	    return new Boolean(true).toString();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return new Boolean(false).toString();
    }
    

    /**
     * Escape an html string. Escaping data received from the client helps to
     * prevent cross-site script vulnerabilities.
     * 
     * @param html the html string to escape
     * @return the escaped string
     */
    private String escapeHtml(String html) {
	if (html == null) {
	    return null;
	}
	
	return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
    
    private Customer getCustomer(BlokiPacket packet) throws MalformedURLException {
	ObjectifyService.register(Customer.class);
	Objectify objectify = ObjectifyService.begin();

	return objectify.query(Customer.class).filter("url", new URL(packet.getUrl()).getHost()).get();
    }

    private void sendMail(Customer customer, BlokiPacket packet, String body) throws UnsupportedEncodingException, MessagingException, MalformedURLException {
	URL url = new URL(packet.getUrl());

	Properties props = new Properties();
	Session session = Session.getDefaultInstance(props, null);

	Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress(url.getHost() + "@bloki-engine.appspotmail.com", "Bloki Bot"));

	message.addRecipient(Message.RecipientType.TO, new InternetAddress(customer.getMail(), "Owner of " + url.getHost()));

	message.setSubject("We found a typo at your blog");
	message.setText(body);

	Transport.send(message);
    }

    private String buildMessage(BlokiPacket packet) {
	String body = "<html>Hello,<p>One of your readers found the following mistake: '<b>" + packet.getMistake() + "</b>' <a href=\"" + packet.getUrl() + "\">on your blog</a>.<br />";
	body += "He suggests to replace it with '<b>" + packet.getCorrection() + "</b>'.</p>Have a great, typo-free day,<br />Bloki Bot.</html>";

	return body;
    }
}
