package tutorials.mahedi.websocket.chat_app.common.message;

public class ClientMessage{
	private int id;
	private String name;

	public ClientMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientMessage(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + "]";
	}

}
