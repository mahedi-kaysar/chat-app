/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER
 */
package tutorials.mahedi.websocket.chat_app.server;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import tutorials.mahedi.websocket.chat_app.message.Client;
import tutorials.mahedi.websocket.chat_app.message.MessageDecoder;
import tutorials.mahedi.websocket.chat_app.message.MessageEncoder;

/**
 * This ChatServerEndPoint.java class is the entry point for each client
 * 
 * @author mahkay
 * 
 */
@ServerEndpoint(value = "/subscribe", decoders = { MessageDecoder.class }, encoders = { MessageEncoder.class })
public class ChatServerEndPoint {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Map<String, Object> properties;

	@OnOpen
	public void onOpen(Session session, EndpointConfig config)
			throws IOException {
		logger.info("onOpen: " + session.getId());
		session.getBasicRemote().sendText("hello, Client!!");
		properties = config.getUserProperties();
		logger.info("properties: " + properties.toString());
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) throws IOException {
		logger.info("onClose: " + session.getId());
	}

	@OnError
	public void onError(Session session, Throwable t) {
		logger.info("onError: " + session.getId());
		t.printStackTrace();
	}

	@OnMessage
	public void onMessage(Client client, Session session) {
		logger.info("onMessage: " + session.getId());
		logger.info("onMessage: " + client.toString());
		for (Session s : session.getOpenSessions()) {
            s.getAsyncRemote().sendObject(client);
        }
	}
}
