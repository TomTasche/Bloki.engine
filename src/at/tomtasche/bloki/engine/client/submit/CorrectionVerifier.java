package at.tomtasche.bloki.engine.client.submit;

public class CorrectionVerifier {

	public String verify(final String mistake, final String correction) {
		if (correction.length() == 0) {
			return "<span style='color: red;'>Please enter a correction.</span>";
		} else if (correction.equals(mistake)) {
			return "<span style='color: red;'>Correction matches mistake. Please insert a valid correction.</span>";
		} else {
			return null;
		}
	}
}
