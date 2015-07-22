package tutorials.mahedi.websocket.chat_app.common.message;

import java.io.IOException;
import java.io.Reader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class TextStreamMessageDecoder implements Decoder.TextStream<XmlWrapper>{

	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		//System.out.println("decoding reader init");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		//System.out.println("decoding reader destroy");
	}
	public XmlWrapper decode(Reader reader) throws DecodeException,
			IOException {
		JsonReader jsonReader = Json.createReader(reader);
		JsonObject jsonObject = jsonReader.readObject();
		System.out.println("XmlWrapper decoding");
		return new XmlWrapper(jsonObject);
	}

}
