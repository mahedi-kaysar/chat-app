/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER
 */
package tutorials.mahedi.websocket.chat_app.server;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

import tutorials.mahedi.websocket.chat_app.common.message.*;

/**
 * This ChatServerEndPoint.java class is the entry point for each client
 * 
 * @author mahkay
 * 
 */
@ServerEndpoint(value = "/subscribe", decoders = { JsonMessageDecoder.class, BinaryStreamMessageDecoder.class}, encoders = { JsonMessageEncoder.class,BinaryStreamMessageEncoder.class })
public class ChatServerEndPoint {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Map<String, Object> properties;

	@OnOpen
	public void onOpen(Session session, EndpointConfig config)
			throws IOException {
		logger.info("onOpen: " + session.getId());
		try {
			Gson gson = new Gson();
			session.getBasicRemote().sendObject(
					gson.toJson(new ServerMessage(1, "connection accepted")));
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
	public void onMessage(JsonWrapper message, Session session) {
		logger.info("JsonWrapper onMessage: " + session.getId());
		// logger.info("onMessage: " + message.toString());
		Gson gson = new Gson();
		ClientMessage clientMessage = gson.fromJson(message.getJson().toString(),
				ClientMessage.class);
		System.out.println(clientMessage.toString());
	}
	@OnMessage
	public void onMessage(BinaryMessage message, Session session) {
		logger.info("BinaryMessage onMessage: " + session.getId());
		System.out.println(message.toString());
	}
}
