package at.tomtasche.bloki.engine.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Register implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final RegisterServiceAsync registerService = GWT
			.create(RegisterService.class);

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		final Button sendButton = new Button("Register");
		final TextBox urlField = new TextBox();
		urlField.setText("Your domain...");
		final TextBox mailField = new TextBox();
		mailField.setText("Your mail address...");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("mailFieldContainer").add(mailField);
		RootPanel.get("urlFieldContainer").add(urlField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		mailField.setFocus(true);
		mailField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox(true);
		dialogBox.setText("Registration");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		final VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending credentials to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			@Override
			public void onClick(final ClickEvent event) {
				this.sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			@Override
			public void onKeyUp(final KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					this.sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a
			 * response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				final String url = urlField.getText();
				final String mail = mailField.getText();

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(url + " and " + mail);
				serverResponseLabel.setText("");
				Register.this.registerService.register(url, mail,
						new AsyncCallback<String>() {
							@Override
							public void onFailure(final Throwable caught) {
								// Show the RPC error message to the user
								dialogBox.setText("Registration - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel
										.setHTML(Register.SERVER_ERROR
												+ "<p>Please send me a mail to <a href='mailto:tomtasche%40gmail.com'>tomtasche@gmail.com</a> so I can find this issue's cause.</p>");
								dialogBox.center();
								closeButton.setFocus(true);
							}

							@Override
							public void onSuccess(final String result) {
								dialogBox.setText("Registration - Success");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		final MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		urlField.addKeyUpHandler(handler);
		mailField.addKeyUpHandler(handler);
	}
}
