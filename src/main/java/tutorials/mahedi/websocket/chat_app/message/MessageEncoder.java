package tutorials.mahedi.websocket.chat_app.message;

//import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class MessageEncoder implements Encoder.Text<Client> {

	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public String encode(Client client) throws EncodeException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		return gson.toJson(client);
		/*return Json.createObjectBuilder().add("ID", client.getId())
				.add("NAME", client.getName()).build().toString();*/
	}

}
