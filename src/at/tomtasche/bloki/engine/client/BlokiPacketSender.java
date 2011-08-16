package at.tomtasche.bloki.engine.client;

import at.tomtasche.bloki.engine.shared.BlokiPacket;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.xhr.client.ReadyStateChangeHandler;
import com.google.gwt.xhr.client.XMLHttpRequest;

public class BlokiPacketSender {

	BlokiPacketCallback callback;

	public BlokiPacketSender(BlokiPacketCallback callback) {
		this.callback = callback;
	}

	public void send(String mistake, String correction, String url) {
		send(new BlokiPacket(mistake, correction, url));
	}

	public void send(BlokiPacket packet) {
		XMLHttpRequest request = XMLHttpRequest.create();
		request.open("POST", "http://bloki-engine.appspot.com/submit");
		request.setOnReadyStateChange(new ReadyStateChangeHandler() {

			@Override
			public void onReadyStateChange(XMLHttpRequest xhr) {
				if (xhr.getStatus() != 200 && xhr.getStatus() != 401) {
					callback.onError();
				} else {
					callback.onSuccess();
				}
			}
		});

		JSONObject object = new JSONObject();
		object.put("mistake", new JSONString(packet.getMistake()));
		object.put("correction", new JSONString(packet.getCorrection()));
		object.put("url", new JSONString(packet.getUrl()));

		request.send(object.toString());
	}

	public interface BlokiPacketCallback {

		public void onError();

		public void onSuccess();

	}
}
