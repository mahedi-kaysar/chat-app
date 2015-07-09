/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER
 */
package tutorials.mahedi.websocket.chat_app.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.logging.Logger;

import org.glassfish.tyrus.server.Server;

/**
 * This ChatServer.java class is for starting the web socket server end point.
 * 
 * @author mahkay
 *
 */
public class ChatServer {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	public static String hostName = "localhost";
	public static int port = 8085;
	public static String contextPath = "/websockets";
	public void runServer() {

		Server server = new Server(hostName, port, contextPath,
				ChatServerEndPoint.class);
		try {
			server.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			logger.info("Please press a key to stop the server.");
			reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.stop();
		}
	}

	public static void main(String[] args) {
		new ChatServer().runServer();
	}
}
