package at.tomtasche.bloki.engine.shared;

public class BlokiPacket {

	String mistake;

	String correction;

	String context;

	String url;

	BlokiPacket() {
	}

	public BlokiPacket(final String mistake, final String correction,
			final String context, final String url) {
		this.mistake = mistake;
		this.correction = correction;
		this.context = context;
		this.url = url;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("BlokiPacket [mistake=").append(this.mistake)
				.append(", correction=").append(this.correction)
				.append(", context=").append(this.context).append(", url=")
				.append(this.url).append("]");
		return builder.toString();
	}

	public String getMistake() {
		return this.mistake;
	}

	public String getCorrection() {
		return this.correction;
	}

	public String getContext() {
		return this.context;
	}

	public String getUrl() {
		return this.url;
	}

	public void setMistake(final String mistake) {
		this.mistake = mistake;
	}

	public void setCorrection(final String correction) {
		this.correction = correction;
	}

	public void setContext(final String context) {
		this.context = context;
	}

	public void setUrl(final String url) {
		this.url = url;
	}
}
