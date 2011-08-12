package at.tomtasche.bloki.engine.client.widget;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;

public class InstructionsDialog extends DialogBox {

    public InstructionsDialog() {
	super(true);

	this.setTitle("Bloki - Crowdsourced typo fixjng");
	this.setText("Bloki - Crowdsourced typo fixjng");

	HTML instructions = new HTML();
	instructions.setHTML("<p>You probably ask yourself what this strange is. Well, it's Bloki.<br />Bloki helps a blog or website's owner to fix typos and missspellings. How? Using <b>your</b> help:<br />If you come across a typo or missspelling simply select the word / sentence and submit a correction. That's it.<br />We'll send the website's owner a mail and he'll decide if he agrees with you or not and probably fix the typo.</p><p>More information at <a href='http://bloki.tomtasche.at/'>bloki.tomtasche.at</a></p>");

	this.add(instructions);

	this.center();
    }
}
