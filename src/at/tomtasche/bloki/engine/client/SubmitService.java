package at.tomtasche.bloki.engine.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("submit")
public interface SubmitService extends RemoteService {
    String submit(String mistake, String correction, String url) throws IllegalArgumentException;
}
