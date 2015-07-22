/**
 * 
 */
package tutorials.mahedi.websocket.chat_app.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import com.google.gson.Gson;

import tutorials.mahedi.websocket.chat_app.common.message.BinaryMessage;
import tutorials.mahedi.websocket.chat_app.common.message.ClientMessage;
import tutorials.mahedi.websocket.chat_app.common.message.JsonWrapper;
import tutorials.mahedi.websocket.chat_app.common.message.ServerMessage;
import tutorials.mahedi.websocket.chat_app.common.message.XmlWrapper;

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

						public void handleMessage(JsonWrapper message) {
							
							logger.info("JsonWrapper handleMessage: "
									+ message.toString());
							Gson gson = new Gson();
							ServerMessage serverMessage = gson.fromJson(message.getJson().toString(), ServerMessage.class);
							System.out.println(serverMessage.toString());

						}

						public void handleMessage(BinaryMessage message) {
							logger.info("BinaryMessage handleMessage: "
									+ message.toString());
							
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
