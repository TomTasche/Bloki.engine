package at.tomtasche.bloki.engine.client.widget;

import at.tomtasche.bloki.engine.client.BlokiPacketSender;
import at.tomtasche.bloki.engine.client.BlokiPacketSender.BlokiPacketCallback;
import at.tomtasche.bloki.engine.client.CorrectionVerifier;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CorrectionDialog extends DialogBox implements ClickHandler,
		BlokiPacketCallback {

	// storing the mistake until we build the json object doesnt work...
	// -> {"mistake":{"extentNode":null, "baseNode":null, "anchorNode":null,
	// "focusNode":null, "rangeCount":0, "anchorOffset":0, "baseOffset":0,
	// "focusOffset":0, "type":"None", "isCollapsed":true, "extentOffset":0},
	// "correction":"Blokiaw ", "url":"http://localhost:8888/submiti.html"}
	// also, checking mistake for its length doesnt work either
	// ... so we're storing it in a invisible label. ;)
	// TODO: find this problem's cause, please.
	Label mistakeLabel;
	TextArea correctionArea;
	HTML statusLabel;
	CorrectionVerifier verifier;
	BlokiPacketSender sender;

	public CorrectionDialog(String mistake) {
		super(true);

		sender = new BlokiPacketSender(this);
		verifier = new CorrectionVerifier();
		mistakeLabel = new Label(mistake);

		this.setTitle("Bloki - Crowdsourced typo fixjng");
		this.setText("Bloki - Crowdsourced typo fixjng");
		this.setAnimationEnabled(true);

		HTML label = new HTML("What should '<b>" + mistake
				+ "</b>' read like instead?");
		correctionArea = new TextArea();
		correctionArea.setWidth("90%");
		correctionArea.setText(mistake);
		correctionArea.setFocus(true);
		correctionArea.selectAll();

		statusLabel = new HTML();

		Button sendButton = new Button("Send");
		sendButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String status = verifier.verify(mistakeLabel.getText(),
						correctionArea.getText());
				if (status != null) {
					statusLabel.setHTML(status);

					return;
				} else {
					statusLabel.setHTML("Sending...");
				}

				String mistake = mistakeLabel.getText();
				String correction = correctionArea.getText();
				String url = Window.Location.getHref();

				sender.send(mistake, correction, url);
			}
		});

		Button closeButton = new Button("Close");
		closeButton.addClickHandler(this);

		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setWidth("100%");
		buttonPanel.add(closeButton);
		buttonPanel.add(sendButton);
		buttonPanel.setCellHorizontalAlignment(closeButton,
				HorizontalPanel.ALIGN_LEFT);
		buttonPanel.setCellHorizontalAlignment(sendButton,
				HorizontalPanel.ALIGN_RIGHT);

		VerticalPanel panel = new VerticalPanel();
		panel.setWidth("100%");
		panel.add(label);
		panel.add(correctionArea);
		panel.add(statusLabel);
		panel.add(buttonPanel);

		this.add(panel);
		this.center();
	}

	@Override
	public void onClick(ClickEvent event) {
		this.hide();
	}

	@Override
	public void onError() {
		statusLabel
				.setHTML("<span style='color: red;'>I couldn't reach the server.\nAre you really connected to the internet?\nIf so, feel free to contact me about this error. :)</span>");
	}

	@Override
	public void onSuccess() {
		this.hide();
	}
}
