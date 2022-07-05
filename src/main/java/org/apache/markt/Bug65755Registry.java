package org.apache.markt;

import java.util.ArrayList;
import java.util.List;

import jakarta.websocket.RemoteEndpoint.Async;

public class Bug65755Registry {

    private static final List<Async> asyncs = new ArrayList<>();

    public static void add(Async async) {
        asyncs.add(async);
    }

    public static void sendMessage(String msg) {
        for (Async async : asyncs) {
            try {
                async.sendText(msg);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
