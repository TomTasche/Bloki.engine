package at.tomtasche.bloki.engine.client;

import at.tomtasche.bloki.engine.client.widget.CorrectionDialog;
import at.tomtasche.bloki.engine.client.widget.InstructionsDialog;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Label;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Submit implements EntryPoint, MouseDownHandler {

	Element lastSelect;


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
		
		Label.wrap(Document.get().getBody()).addMouseUpHandler(new MouseUpHandler() {

			@Override
			public void onMouseUp(MouseUpEvent event) {
				lastSelect = Element.as(Element.as(event.getNativeEvent().getEventTarget()).cloneNode(true));
			}
		});

		Document.get().getBody().appendChild(bloki_div);
	}

	@Override
	public final void onMouseDown(final MouseDownEvent event) {
		final String mistake = this.getSelectedText();
		final Label mistakeLabel = new Label(mistake);

		if (mistakeLabel.getText() == null
				|| mistakeLabel.getText().trim().length() == 0) {
			// Window.open("http://goo.gl/Ortds", "_blank", null);

			new InstructionsDialog().show();

			return;
		}

		new CorrectionDialog(mistake).show();
	}

	/**
	 * @author codetoad.com -
	 *         http://www.codetoad.com/javascript_get_selected_text.asp
	 * @returns {String}
	 */
	private native String getSelectedText() /*-{
		var text = '';

		if (window.getSelection) {
			text = window.getSelection();
		} else if (document.getSelection) {
			text = document.getSelection();
		} else if (document.selection) {
			text = document.selection.createRange().text;
		}

		return text;
	}-*/;
}
