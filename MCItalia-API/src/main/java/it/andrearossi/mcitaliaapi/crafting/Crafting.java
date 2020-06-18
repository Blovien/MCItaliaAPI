package it.andrearossi.mcitaliaapi.crafting;

import com.google.gson.annotations.SerializedName;
import it.andrearossi.mcitaliaapi.utils.html.APIObject;

public class Crafting implements APIObject {

	static final String ID_CATEGORY_FIELD = "id_category";
	static final String NAME_ITALIAN_FIELD = "name_italian";
	static final String URL_ITALIAN_FIELD = "url_italian";
	static final String PRIMARY_BLOCK_FIELD = "primary_block";

	private short id;

	@SerializedName(ID_CATEGORY_FIELD)
	private byte idCategory;

	private String name;

	@SerializedName(NAME_ITALIAN_FIELD)
	private String nameItalian;

	@SerializedName(URL_ITALIAN_FIELD)
	private String urlItalian;

	private boolean hidden;

	@SerializedName(PRIMARY_BLOCK_FIELD)
	private boolean primaryBlock;

	public Crafting(short id, byte idCategory, String name, String nameItalian, String urlItalian, boolean hidden, boolean primaryBlock) {
		this.id = id;
		this.idCategory = idCategory;
		this.name = name;
		this.nameItalian = nameItalian;
		this.urlItalian = urlItalian;
		this.hidden = hidden;
		this.primaryBlock = primaryBlock;
	}

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public byte getIdCategory() {
		return idCategory;
	}

	public String getNameItalian() {
		return nameItalian;
	}

	public String getUrlItalian() {
		return urlItalian;
	}
}
