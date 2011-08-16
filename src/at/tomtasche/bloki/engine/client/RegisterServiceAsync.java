package at.tomtasche.bloki.engine.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>RegisterService</code>.
 */
public interface RegisterServiceAsync {
	void register(String url, String mail, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
