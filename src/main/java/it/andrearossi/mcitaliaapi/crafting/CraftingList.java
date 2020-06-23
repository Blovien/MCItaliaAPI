package it.andrearossi.mcitaliaapi.crafting;

import it.andrearossi.mcitaliaapi.utils.html.JsonCategoryList;

public class CraftingList extends JsonCategoryList<Crafting, CraftingCategory> {

	public CraftingList(String status, Crafting[] items, CraftingCategory[] categories) {
		super(status, items, categories);
	}
}
