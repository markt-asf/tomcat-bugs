package org.apache.markt;

import jakarta.websocket.OnOpen;
import jakarta.websocket.RemoteEndpoint.Async;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/Bug65755Endpoint")
public class Bug65755Endpoint {

    @OnOpen
    public void start(Session session) {
        Async async = session.getAsyncRemote();
        Bug65755Registry.add(async);
    }
}
