package at.tomtasche.bloki.engine.client;

import at.tomtasche.bloki.engine.client.widget.CorrectionDialog;
import at.tomtasche.bloki.engine.client.widget.InstructionsDialog;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Label;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Submit implements EntryPoint, MouseDownHandler {

    @Override
    public void onModuleLoad() {
	Element div = DOM.createDiv();
	div.setAttribute("class", "bloki_div");

	Label.wrap(div).addMouseDownHandler(this);

	Document.get().getBody().appendChild(div);
    }
    
    @Override
    public void onMouseDown(MouseDownEvent event) {
	String mistake = getSelectedText();
	Label mistakeLabel = new Label(mistake);

	if (mistakeLabel.getText() == null || mistakeLabel.getText().trim().length() == 0) {
	    // Window.open("http://goo.gl/Ortds", "_blank", null);
	    
	    new InstructionsDialog().show();

	    return;
	}

	new CorrectionDialog(mistake).show();
    }


    /**
     * @author codetoad.com - http://www.codetoad.com/javascript_get_selected_text.asp
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
