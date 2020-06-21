package it.andrearossi.mcitaliaapi.utils.html;

import com.google.gson.JsonParser;

public class JsonCategoryList<T extends APIObject, K extends JsonCategory> extends JsonList<T> {

	private final K[] categories;

	public JsonCategoryList(String status, T[] items, K[] categories) {
		super(status, items);
		this.categories = categories;
	}

	public K[] getCategories() {
		return categories;

	}

}
