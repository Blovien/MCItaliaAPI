package it.andrearossi.mcitaliaapi.utils.html;

public class JsonCategoryList<T extends APIObject, K extends JsonCategory> implements APIObject {

	private final String status;

	private final T[] items;

	private final K[] categories;

	public JsonCategoryList(String status, T[] items, K[] categories) {
		this.status = status;
		this.items = items;
		this.categories = categories;
	}

	public K[] getCategories() {
		return categories;
	}

	public T[] getItems() {
		return items;
	}

	public String getStatus() {
		return status;
	}
}
