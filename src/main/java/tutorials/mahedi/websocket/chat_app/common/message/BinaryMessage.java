package tutorials.mahedi.websocket.chat_app.common.message;

import java.io.Serializable;

public class BinaryMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public BinaryMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BinaryMessage(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BinaryMessage [name=" + name + "]";
	}
	
}
