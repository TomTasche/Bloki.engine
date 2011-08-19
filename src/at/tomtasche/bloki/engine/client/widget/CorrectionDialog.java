package at.tomtasche.bloki.engine.client.widget;

import at.tomtasche.bloki.engine.client.BlokiPacketSender;
import at.tomtasche.bloki.engine.client.BlokiPacketSender.BlokiPacketCallback;
import at.tomtasche.bloki.engine.client.CorrectionVerifier;
import at.tomtasche.bloki.engine.shared.BlokiPacket;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CorrectionDialog extends DialogBox implements ClickHandler,
		BlokiPacketCallback {

	BlokiPacket packet;
	TextArea correctionArea;
	HTML statusLabel;
	CorrectionVerifier verifier;
	BlokiPacketSender sender;

	public CorrectionDialog(final String mistake, final String context) {
		super(true);

		this.sender = new BlokiPacketSender(this);
		this.verifier = new CorrectionVerifier();
		this.packet = new BlokiPacket(mistake, null, context, null);

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
						CorrectionDialog.this.packet.getMistake(),
						CorrectionDialog.this.correctionArea.getText());
				if (status != null) {
					CorrectionDialog.this.statusLabel.setHTML(status);

					return;
				} else {
					CorrectionDialog.this.statusLabel.setHTML("Sending...");
				}

				CorrectionDialog.this.packet
						.setCorrection(CorrectionDialog.this.correctionArea
								.getText());
				CorrectionDialog.this.packet.setUrl(Window.Location.getHref());

				CorrectionDialog.this.sender.send(CorrectionDialog.this.packet);
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
