package at.tomtasche.bloki.engine.client;

import at.tomtasche.bloki.engine.shared.BlokiPacket;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.xhr.client.ReadyStateChangeHandler;
import com.google.gwt.xhr.client.XMLHttpRequest;

public class BlokiPacketSender {

	BlokiPacketCallback callback;

	public BlokiPacketSender(final BlokiPacketCallback callback) {
		this.callback = callback;
	}

	public void send(final String mistake, final String correction,
			final String context, final String url) {
		this.send(new BlokiPacket(mistake, correction, context, url));
	}

	public void send(final BlokiPacket packet) {
		final XMLHttpRequest request = XMLHttpRequest.create();
		request.open("POST", "http://bloki-engine.appspot.com/submit");
		request.setOnReadyStateChange(new ReadyStateChangeHandler() {

			@Override
			public void onReadyStateChange(final XMLHttpRequest xhr) {
				if (xhr.getStatus() != 200 && xhr.getStatus() != 401) {
					BlokiPacketSender.this.callback.onError();
				} else {
					BlokiPacketSender.this.callback.onSuccess();
				}
			}
		});

		final JSONObject object = new JSONObject();
		object.put("mistake", new JSONString(packet.getMistake()));
		object.put("correction", new JSONString(packet.getCorrection()));
		object.put("context", new JSONString(packet.getContext()));
		object.put("url", new JSONString(packet.getUrl()));

		request.send(object.toString());
	}

	public interface BlokiPacketCallback {

		public void onError();

		public void onSuccess();

	}
}
