package tutorials.mahedi.websocket.chat_app.common.message;

import javax.json.JsonObject;

public class XmlWrapper {
	private JsonObject json;

	public XmlWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XmlWrapper(JsonObject json) {
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
