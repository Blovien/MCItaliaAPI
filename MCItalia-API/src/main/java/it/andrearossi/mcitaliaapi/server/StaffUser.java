package it.andrearossi.mcitaliaapi.server;

import it.andrearossi.mcitaliaapi.utils.html.APIObject;
import it.andrearossi.mcitaliaapi.utils.Constants;

public class StaffUser implements APIObject {

	private String uuid;
	private String username;

	public StaffUser(String uuid, String username) {
		this.uuid = uuid;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getUuid() {
		return uuid;
	}

	public String getAvatarURL(String size) {
		return Constants.AVATAR_URL + size + "/" + uuid;
	}
}
