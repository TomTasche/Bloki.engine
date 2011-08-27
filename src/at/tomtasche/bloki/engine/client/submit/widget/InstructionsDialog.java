package at.tomtasche.bloki.engine.client.submit.widget;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;

public class InstructionsDialog extends DialogBox {

	public InstructionsDialog() {
		super(true);

		this.setTitle("Bloki - Crowdsourced typo fixjng");
		this.setText("Bloki - Crowdsourced typo fixjng");

		final HTML instructions = new HTML();
		instructions.setWordWrap(true);
		instructions
				.setHTML("<p>You probably ask yourself what this strange thing is. Well, it's Bloki.<p>"
						+ "<h1 style='margin-bottom: 0px; margin-top: 0px;'>How to use Bloki</h1>"
						+
						// "If you come across a typo or missspelling simply <b>select</b> the word / sentence, click the Bloki button and submit a correction."
						// +
						"<ol style='margin-top: 0px'>"
						+ "<li>Read this blog...</li>"
						+ "<li>Come across a typo or misspelling</li>"
						+ "<li>Select the wrong word or sentence with your mouse</li>"
						+ "<li>Click the Bloki button (the one that brought you here)</li>"
						+ "<li>Submit a proper correction for the selected mistake</li>"
						+ "</ol>" + "<p style='color: grey;'>That's it.<br />" +
						// "We'll send the website's owner a mail and he'll decide if he agrees with you or not and probably fix the typo.</p>"
						// +
						"More information about Bloki and what happens with your corrections at <a href='http://goo.gl/Ortds'>bloki.tomtasche.at</a></p>");

		this.add(instructions);

		this.center();
	}
}
