package at.tomtasche.bloki.engine.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("register")
public interface RegisterService extends RemoteService {
    String register(String url, String mail) throws IllegalArgumentException;
}
