package tutorials.mahedi.websocket.chat_app.common.message;

import java.io.IOException;
import java.io.Writer;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class TextStreamMessageEncoder implements Encoder.TextStream<XmlWrapper>{

	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		//System.out.println("encoding reader init");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		//System.out.println("encoding reader destroy");
	}

	public void encode(XmlWrapper object, Writer writer)
			throws EncodeException, IOException {
		JsonWriter jsonWriter = Json.createWriter(writer);
		JsonObject jsonObject = object.getJson();
		jsonWriter.write(jsonObject);
		
	}

}
