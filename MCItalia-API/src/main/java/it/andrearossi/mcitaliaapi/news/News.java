package it.andrearossi.mcitaliaapi.news;

import com.google.gson.annotations.SerializedName;
import it.andrearossi.mcitaliaapi.utils.html.APIObject;

public class News implements APIObject {

	static final String LAYOUT_TYPE_FIELD = "layout_type";
	static final String ID_IMAGE_FIELD = "id_image";

	private String title;

	private String url;

	@SerializedName(LAYOUT_TYPE_FIELD)
	private byte layoutType;

	@SerializedName(ID_IMAGE_FIELD)
	private short idImage;


}
