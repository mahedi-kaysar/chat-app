package tutorials.mahedi.websocket.chat_app.common.message;

import javax.json.JsonObject;

public class JsonWrapper {
	private JsonObject json;
	
	public JsonWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonWrapper(JsonObject json) {
		super();
		this.json = json;
	}

	public JsonObject getJson() {
		return json;
	}

	public void setJson(JsonObject json) {
		this.json = json;
	}

	@Override
	public String toString() {
		return "Message [json=" + json + "]";
	}
	
	
}
