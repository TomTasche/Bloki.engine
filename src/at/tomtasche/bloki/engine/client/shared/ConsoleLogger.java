package at.tomtasche.bloki.engine.client.shared;

public class ConsoleLogger {

	public native static void log(String message)
	/*-{
		console.log(message);
	}-*/;
}
