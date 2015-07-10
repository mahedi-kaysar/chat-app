/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER
 */
package tutorials.mahedi.websocket.chat_app.client;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.logging.Logger;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import com.google.gson.Gson;

import tutorials.mahedi.websocket.chat_app.common.message.*;

/**
 * This ChatClientEndPoint.java class is for each client
 * 
 * @author mahkay
 * 
 */
@ClientEndpoint(decoders = { MessageDecoder.class }, encoders = { MessageEncoder.class })
public class ChatClientEndPoint {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Map<String, Object> properties;
	Session userSession = null;
	private MessageHandler messageHandler;

	public ChatClientEndPoint(URI endpointURI) {
		try {
			WebSocketContainer container = ContainerProvider
					.getWebSocketContainer();
			container.connectToServer(this, endpointURI);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@OnOpen
	public void onOpen(Session session, EndpointConfig config)
			throws IOException {
		logger.info("onOpen: " + session.getId());
		try {
			Gson gson = new Gson();
			session.getBasicRemote().sendObject(
					gson.toJson(new ClientMessage(1, "Mahedi")));
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void onMessage(String message, Session session) {
		logger.info("onMessage: " + session.getId());
		if (this.messageHandler != null)
			this.messageHandler.handleMessage(message);

	}

	/**
	 * register message handler
	 * 
	 * @param message
	 */
	public void addMessageHandler(MessageHandler msgHandler) {
		this.messageHandler = msgHandler;
	}

	/**
	 * Send a message.
	 * 
	 * @param user
	 * @param message
	 */
	public void sendMessage(String message) {
		this.userSession.getAsyncRemote().sendText(message);
	}

	public void close() {
		try {
			this.userSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Message handler.
	 * 
	 * @author mahkay
	 */
	public static interface MessageHandler {
		public void handleMessage(String message);
	}
}
