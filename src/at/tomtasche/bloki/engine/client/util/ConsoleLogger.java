package at.tomtasche.bloki.engine.client.util;

public class ConsoleLogger {

	public native static void log(String message)
	/*-{
		console.log(message);
	}-*/;
}
