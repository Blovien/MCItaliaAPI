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

	public News(String title, String url, byte layoutType, short idImage) {
		this.title = title;
		this.url = url;
		this.layoutType = layoutType;
		this.idImage = idImage;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public byte getLayoutType() {
		return layoutType;
	}

	public short getIdImage() {
		return idImage;
	}
}
