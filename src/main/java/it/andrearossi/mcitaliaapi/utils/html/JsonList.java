package it.andrearossi.mcitaliaapi.utils.html;

public class JsonList<T extends APIObject> implements APIObject {

	private final String status;

	private final T[] items;

	public JsonList(String status, T[] items) {
		this.status = status;
		this.items = items;
	}

	public T[] getItems() {
		return items;
	}

	public String getStatus() {
		return status;
	}
}
