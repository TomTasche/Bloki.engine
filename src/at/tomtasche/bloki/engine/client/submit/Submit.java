package at.tomtasche.bloki.engine.client.submit;

import at.tomtasche.bloki.engine.client.submit.widget.CorrectionDialog;
import at.tomtasche.bloki.engine.client.submit.widget.InstructionsDialog;

import com.bfr.client.selection.Selection;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Label;

public class Submit implements EntryPoint, MouseDownHandler {

	@Override
	public void onModuleLoad() {
		final Element bloki_div = DOM.createDiv();
		bloki_div.setAttribute("class", "bloki_div");

		final Element bloki_left = DOM.createDiv();
		bloki_left.setAttribute("class", "bloki_left");

		final Element bloki_center = DOM.createDiv();
		bloki_center.setAttribute("class", "bloki_center");

		final Element bloki_right = DOM.createDiv();
		bloki_right.setAttribute("class", "bloki_right");

		bloki_div.appendChild(bloki_left);
		bloki_div.appendChild(bloki_center);
		bloki_div.appendChild(bloki_right);

		Label.wrap(bloki_div).addMouseDownHandler(this);

		Document.get().getBody().appendChild(bloki_div);
	}

	@Override
	public final void onMouseDown(final MouseDownEvent event) {
		String mistake = null;
		try {
			// i'm too lazy to find out which one of these is null...
			mistake = Selection.getSelection().getRange().getText();
		} catch (final Exception e) {
		}

		if (mistake == null || mistake.trim().length() == 0) {
			new InstructionsDialog().show();

			return;
		}

		final StringBuilder contextBuilder = new StringBuilder();
		for (final Text text : Selection.getSelection().getRange()
				.getSelectedTextElements()) {
			contextBuilder.append(text.getData());
		}

		final String context = contextBuilder.toString();

		new CorrectionDialog(mistake, context).show();
	}
}
