/**
 * 
 */
package tutorials.mahedi.websocket.chat_app.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import tutorials.mahedi.websocket.chat_app.message.Client;

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

						public void handleMessage(Client client) {
							// TODO Auto-generated method stub
							logger.info("handleMessage: "+ client.toString());
						}
					});
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(true){
			
		}
	}

}
