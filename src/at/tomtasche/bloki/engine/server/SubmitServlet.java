package at.tomtasche.bloki.engine.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.tomtasche.bloki.engine.shared.BlokiPacket;

import com.google.gson.Gson;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class SubmitServlet extends HttpServlet {

	@Override
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	@Override
	protected void doOptions(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, Content-Type");
		response.setHeader("Access-Control-Max-Age", "1728000");
	}

	@Override
	public void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");

		final InputStreamReader reader = new InputStreamReader(
				request.getInputStream(), Charset.forName("UTF-8"));
		final BlokiPacket packet = new Gson().fromJson(reader,
				BlokiPacket.class);
		if (packet == null)
			return;

		final String body = this.buildMessage(packet);

		try {
			Customer customer = this.getCustomer(packet);
			if (customer == null) {
				customer = new Customer(new URL(packet.getUrl()).getHost(),
						"tomtasche+bloki-engine@gmail.com");

				this.sendMail(customer, packet, body);

				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

				return;
			}

			this.sendMail(customer, packet, body);

			response.setStatus(HttpServletResponse.SC_OK);
		} catch (final Exception e) {
			e.printStackTrace();

			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					e.getMessage());

			e.printStackTrace(response.getWriter());
		} finally {
			reader.close();
		}
	}

	private Customer getCustomer(final BlokiPacket packet)
			throws MalformedURLException {
		ObjectifyService.register(Customer.class);
		final Objectify objectify = ObjectifyService.begin();

		final String url = new URL(packet.getUrl()).getHost();

		return objectify.query(Customer.class).filter("url", url).get();
	}

	private void sendMail(final Customer customer, final BlokiPacket packet,
			final String body) throws UnsupportedEncodingException,
			MessagingException, MalformedURLException {
		final URL url = new URL(packet.getUrl());

		final Properties props = new Properties();
		final Session session = Session.getDefaultInstance(props, null);

		final MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(url.getHost()
				+ "@bloki-engine.appspotmail.com", "Bloki Bot"));

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
				customer.getMail(), "Owner of " + url.getHost()));

		message.setSubject("We found a typo at your blog");
		message.setText(body, "text/html");
		message.addHeader("Content-Type", "text/html");

		Transport.send(message);
	}

	private String buildMessage(final BlokiPacket packet) {
		String body = "<html>Hello,<p>One of your readers found the following mistake: '<b>"
				+ packet.getMistake()
				+ "</b>' <a href=\""
				+ packet.getUrl()
				+ "\">on your blog</a>.<br />";
		body += "He suggests to replace it with '<b>"
				+ packet.getCorrection()
				+ "</b>'.</p>Have a great, typo-free day,<br /><a href='http://goo.gl/dK84V'>Tom</a> and your Bloki Bot.";
		body += "<p>PS: I would love to hear from you! If you have anything to say about Bloki, ping me at <a href='mailto:tomtasche+bloki@gmail.com'>tomtasche@gmail.com</a></p>";

		if (packet.getContext() != null && packet.getContext().trim().isEmpty()) {
			body += "<p>PPS: That's what we guess is the mistake's enclosing text: <p><i>"
					+ packet.getContext()
					+ "</i></p>Please don't think that's correct for sure! It's just a guess...</p>";
		}

		body += "</html>";

		return body;
	}
}