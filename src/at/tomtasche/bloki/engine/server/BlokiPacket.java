package at.tomtasche.bloki.engine.server;

public class BlokiPacket {

    String mistake;
    
    String correction;
    
    String context;
    
    String url;
    
    
    BlokiPacket() {}
    
    public BlokiPacket(String mistake, String correction, String context, String url) {
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
    
    public String getContext() {
	return context;
    }
    
    public String getUrl() {
	return url;
    }
}
