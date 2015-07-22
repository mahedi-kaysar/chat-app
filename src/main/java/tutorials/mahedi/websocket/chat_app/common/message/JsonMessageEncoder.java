package tutorials.mahedi.websocket.chat_app.common.message;

//import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class JsonMessageEncoder implements Encoder.Text<JsonWrapper> {

	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public String encode(JsonWrapper jsonWrapper) throws EncodeException {
		return jsonWrapper.getJson().toString();
	}

}
