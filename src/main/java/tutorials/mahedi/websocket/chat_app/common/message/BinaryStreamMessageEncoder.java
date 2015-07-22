package tutorials.mahedi.websocket.chat_app.common.message;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class BinaryStreamMessageEncoder implements Encoder.BinaryStream<BinaryMessage>{

	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void encode(BinaryMessage object, OutputStream os)
			throws EncodeException, IOException {
		ObjectOutput objectOutput = new ObjectOutputStream(os);
		objectOutput.writeObject(object);
		
	}

}
