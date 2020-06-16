package it.andrearossi.mcitaliaapi.server;

import it.andrearossi.mcitaliaapi.APIObject;
import it.andrearossi.mcitaliaapi.utils.Costants;
import it.andrearossi.mcitaliaapi.utils.Ignore;

public class User implements APIObject {

	private String uuid;
	private String username;

	public User(String uuid, String username) {
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
		return Costants.AVATAR_URL + size + "/" + uuid;
	}
}
