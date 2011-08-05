package at.tomtasche.bloki.engine.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.xhr.client.ReadyStateChangeHandler;
import com.google.gwt.xhr.client.XMLHttpRequest;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Submit implements EntryPoint {

    @Override
    public void onModuleLoad() {
	Element div = DOM.createDiv();
	div.setAttribute("style", "position:fixed; right:10px; bottom: 0; box-shadow: 0 0 10px #666; padding:10px; background-color:#333; color:#FFF; font-family: Arial;");
	div.setInnerText("Bloki - Fix typos");

	Label.wrap(div).addMouseDownHandler(new MouseDownHandler() {

	    @Override
	    public void onMouseDown(MouseDownEvent event) {
		// storing the mistake until we build the json object doesnt work...
		// -> {"mistake":{"extentNode":null, "baseNode":null, "anchorNode":null, "focusNode":null, "rangeCount":0, "anchorOffset":0, "baseOffset":0, "focusOffset":0, "type":"None", "isCollapsed":true, "extentOffset":0}, "correction":"Blokiaw ", "url":"http://localhost:8888/submiti.html"}
		String mistake = getSelectedText();

		// ... so we're storing it in a invisible textbox. ;) PWND!
		// TODO: find this problem's cause, please.
		final TextBox hack = new TextBox();
		hack.setText(mistake);

		if (mistake.length() == 0) {
		    // TODO: show instructions.

		    return;
		}

		final DialogBox dialog = new DialogBox();
		dialog.setText("Bloki - Crowdsourced typo fixjng");
		dialog.setAnimationEnabled(true);

		Label label = new Label("What should '" + mistake + "' read like instead?");
		final TextBox textBox = new TextBox();
		textBox.setWidth("90%");
		textBox.setText(mistake);

		Button sendButton = new Button("Send");
		sendButton.addClickHandler(new ClickHandler() {

		    @Override
		    public void onClick(ClickEvent event) {
			if (textBox.getText().length() == 0 || textBox.getText().equals(hack.getText())) {
			    return;
			}

			XMLHttpRequest request = XMLHttpRequest.create();
			request.open("POST", "http://003.bloki-engine.appspot.com/submit");
			request.setOnReadyStateChange(new ReadyStateChangeHandler() {

			    @Override
			    public void onReadyStateChange(XMLHttpRequest xhr) {
				dialog.hide();
				
				if (xhr.getStatus() != 200 && xhr.getStatus() != 401) {
				    final DialogBox box = new DialogBox();
				    
				    Button closeButton = new Button("Close");
				    closeButton.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
					    box.hide();
					}
				    });

				    VerticalPanel panel = new VerticalPanel();
				    panel.setWidth("100%");
				    panel.add(new Label("I couldn't reach the server.\nAre you really connected to the internet?\nIf so, feel free to contact me about this error. :)"));
				    panel.add(closeButton);

				    box.add(panel);
				    box.center();
				    box.show();
				}
			    }
			});

			JSONObject object = new JSONObject();
			object.put("mistake", new JSONString(hack.getText()));
			object.put("correction", new JSONString(textBox.getText()));
			object.put("url", new JSONString(Window.Location.getHref()));

			request.send(object.toString());
		    }
		});

		Button closeButton = new Button("Close");
		closeButton.addClickHandler(new ClickHandler() {

		    @Override
		    public void onClick(ClickEvent event) {
			dialog.hide();
		    }
		});

		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setWidth("100%");
		buttonPanel.add(closeButton);
		buttonPanel.add(sendButton);
		buttonPanel.setCellHorizontalAlignment(closeButton, HorizontalPanel.ALIGN_LEFT);
		buttonPanel.setCellHorizontalAlignment(sendButton, HorizontalPanel.ALIGN_RIGHT);

		VerticalPanel panel = new VerticalPanel();
		panel.setWidth("100%");
		panel.add(label);
		panel.add(textBox);
		panel.add(buttonPanel);

		dialog.add(panel);

		dialog.center();
		dialog.show();

		textBox.setFocus(true);
	    }
	});

	getBody().appendChild(div);
    }


    private native Element getBody() /*-{
    	return document.getElementsByTagName('body')[0];
    }-*/;

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
