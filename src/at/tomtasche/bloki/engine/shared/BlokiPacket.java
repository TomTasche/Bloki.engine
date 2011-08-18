package at.tomtasche.bloki.engine.shared;

public class BlokiPacket {

	String mistake;

	String correction;

	String url;

	BlokiPacket() {
	}

	public BlokiPacket(final String mistake, final String correction,
			final String url) {
		this.mistake = mistake;
		this.correction = correction;
		this.url = url;
	}

	public String getMistake() {
		return this.mistake;
	}

	public String getCorrection() {
		return this.correction;
	}

	public String getUrl() {
		return this.url;
	}
}
