package at.tomtasche.bloki.engine.client;

public class CorrectionVerifier {

	public String verify(String mistake, String correction) {
		if (correction.length() == 0) {
			return "<span style='color: red;'>Please enter a correction.</span>";
		} else if (correction.equals(mistake)) {
			return "<span style='color: red;'>Correction matches mistake. Please insert a valid correction.</span>";
		} else {
			return null;
		}
	}
}
