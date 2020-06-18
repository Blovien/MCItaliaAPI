package it.andrearossi.mcitaliaapi.news;

import it.andrearossi.mcitaliaapi.utils.html.JsonList;

public class NewsList extends JsonList<News> {

	public NewsList(String status, News[] items) {
		super(status, items);
	}
}
