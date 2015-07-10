/**
 * 
 */
package tutorials.mahedi.websocket.chat_app.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import com.google.gson.Gson;

import tutorials.mahedi.websocket.chat_app.common.message.ClientMessage;
import tutorials.mahedi.websocket.chat_app.common.message.ServerMessage;

/**
 * @author mahkay
 *
 */
public class ChatClient {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	public static String endpointURI = "ws://localhost:8085/websockets/subscribe";

	public static void main(String[] args) {

		new ChatClient().subscribe();
	}

	public void subscribe() {
		try {
			new ChatClientEndPoint(new URI(endpointURI))
					.addMessageHandler(new ChatClientEndPoint.MessageHandler() {

						public void handleMessage(String message) {
							
							logger.info("handleMessage: "
									+ message.toString());
							Gson gson = new Gson();
							ServerMessage serverMessage = gson.fromJson(message, ServerMessage.class);
							System.out.println(serverMessage.toString());

						}
					});
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {

		}
	}

}
