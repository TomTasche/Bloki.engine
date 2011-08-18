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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
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

	public CorrectionDialog(final String mistake) {
		super(true);

		this.sender = new BlokiPacketSender(this);
		this.verifier = new CorrectionVerifier();
		this.mistakeLabel = new Label(mistake);

		this.setTitle("Bloki - Crowdsourced typo fixjng");
		this.setText("Bloki - Crowdsourced typo fixjng");
		this.setAnimationEnabled(true);

		final HTML label = new HTML("What should '<b>" + mistake
				+ "</b>' read like instead?");
		this.correctionArea = new TextArea();
		this.correctionArea.setWidth("90%");
		this.correctionArea.setText(mistake);
		this.correctionArea.setFocus(true);
		this.correctionArea.selectAll();

		this.statusLabel = new HTML();

		final Button sendButton = new Button("Send");
		sendButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				final String status = CorrectionDialog.this.verifier.verify(
						CorrectionDialog.this.mistakeLabel.getText(),
						CorrectionDialog.this.correctionArea.getText());
				if (status != null) {
					CorrectionDialog.this.statusLabel.setHTML(status);

					return;
				} else {
					CorrectionDialog.this.statusLabel.setHTML("Sending...");
				}

				final String mistake = CorrectionDialog.this.mistakeLabel
						.getText();
				final String correction = CorrectionDialog.this.correctionArea
						.getText();
				final String url = Window.Location.getHref();

				CorrectionDialog.this.sender.send(mistake, correction, url);
			}
		});

		final Button closeButton = new Button("Close");
		closeButton.addClickHandler(this);

		final HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setWidth("100%");
		buttonPanel.add(closeButton);
		buttonPanel.add(sendButton);
		buttonPanel.setCellHorizontalAlignment(closeButton,
				HasHorizontalAlignment.ALIGN_LEFT);
		buttonPanel.setCellHorizontalAlignment(sendButton,
				HasHorizontalAlignment.ALIGN_RIGHT);

		final VerticalPanel panel = new VerticalPanel();
		panel.setWidth("100%");
		panel.add(label);
		panel.add(this.correctionArea);
		panel.add(this.statusLabel);
		panel.add(buttonPanel);

		this.add(panel);
		this.center();
	}

	@Override
	public void onClick(final ClickEvent event) {
		this.hide();
	}

	@Override
	public void onError() {
		this.statusLabel
				.setHTML("<span style='color: red;'>I couldn't reach the server.\nAre you really connected to the internet?\nIf so, feel free to contact me about this error. :)</span>");
	}

	@Override
	public void onSuccess() {
		this.hide();
	}
}
