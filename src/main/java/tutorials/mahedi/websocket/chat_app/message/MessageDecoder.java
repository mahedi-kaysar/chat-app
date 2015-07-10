package tutorials.mahedi.websocket.chat_app.message;

//import java.io.StringReader;
//import javax.json.Json;
//import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class MessageDecoder implements Decoder.Text<Client>{

	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public Client decode(String s) throws DecodeException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		
		/*JsonObject jsonObject = Json.createReader(new StringReader(s)).readObject();
		Client client = new Client();
		client.setId(jsonObject.getInt("ID"));
		client.setName(jsonObject.getString("NAME"));
        return client;*/
		
		return gson.fromJson(s, Client.class);
	}

	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		return (s != null);
	}

}
