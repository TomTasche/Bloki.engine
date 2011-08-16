package at.tomtasche.bloki.engine.shared;

public class BlokiPacket {

	String mistake;

	String correction;

	String url;

	BlokiPacket() {
	}

	public BlokiPacket(String mistake, String correction, String url) {
		this.mistake = mistake;
		this.correction = correction;
		this.url = url;
	}

	public String getMistake() {
		return mistake;
	}

	public String getCorrection() {
		return correction;
	}

	public String getUrl() {
		return url;
	}
}
