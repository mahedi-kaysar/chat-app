package tutorials.mahedi.websocket.chat_app.common.message;

public class ServerMessage{
	private int id;
	private String message;
	public ServerMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServerMessage(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ServerMessage [id=" + id + ", message=" + message + "]";
	}
}
