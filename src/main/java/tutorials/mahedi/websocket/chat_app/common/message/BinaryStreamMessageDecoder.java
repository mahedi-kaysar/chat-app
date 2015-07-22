package tutorials.mahedi.websocket.chat_app.common.message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class BinaryStreamMessageDecoder implements Decoder.BinaryStream<BinaryMessage>{

	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public BinaryMessage decode(InputStream is) throws DecodeException,
			IOException {
		ObjectInput objectInput = new ObjectInputStream(is);
		System.out.println("BinaryMessage decode");
		try {
			BinaryMessage binaryMessage= (BinaryMessage) objectInput.readObject();
			return binaryMessage;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
