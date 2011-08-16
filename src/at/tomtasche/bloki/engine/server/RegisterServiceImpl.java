package at.tomtasche.bloki.engine.server;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import at.tomtasche.bloki.engine.client.RegisterService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class RegisterServiceImpl extends RemoteServiceServlet implements
		RegisterService {

	public String register(String urlString, String mail)
			throws IllegalArgumentException {
		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		urlString = escapeHtml(urlString);
		mail = escapeHtml(mail);

		URL url;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			urlString = "http://" + urlString;

			try {
				url = new URL(urlString);
			} catch (MalformedURLException e1) {
				return "Couldn't parse your URL: '" + urlString + "'.";
			}
		}

		if (!isValidEmailAddress(mail)) {
			return "Couldn't parse your mail: '" + mail + "'.";
		}

		createCustomer(url.getHost(), mail);

		return "Welcome, <a href='http://"
				+ url.getHost()
				+ "/'>"
				+ url.getHost()
				+ "</a>. Thank you very much for signing up for Bloki. I can't wait to hear what you think...<br />Now head over to the <a href='http://goo.gl/PUYGd'>instructions on how to install Bloki on your blog</a>.";
	}

	private void createCustomer(String url, String mail) {
		ObjectifyService.register(Customer.class);
		Objectify objectify = ObjectifyService.begin();

		Customer customer = new Customer(url, mail);

		objectify.put(customer);
	}

	/**
	 * @author Dominic Bartl - http://bartinger.at/
	 * @param mail
	 * @return
	 */
	private boolean isValidEmailAddress(String mail) {
		String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
