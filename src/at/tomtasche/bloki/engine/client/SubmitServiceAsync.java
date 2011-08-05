package at.tomtasche.bloki.engine.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>RegisterService</code>.
 */
public interface SubmitServiceAsync {
    void submit(String mistake, String correction, String url, AsyncCallback<String> callback) throws IllegalArgumentException;
}
