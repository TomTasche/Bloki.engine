package at.tomtasche.bloki.engine.server;

public class BlokiPacket {

    String mistake;
    
    String correction;
    
    String url;
    
    
    public BlokiPacket() {}
    
    
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
