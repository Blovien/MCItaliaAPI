package it.andrearossi.mcitaliaapi.server;

import it.andrearossi.mcitaliaapi.APIObject;

public class User implements APIObject {

	private String uuid;
	private String username;

	public User(String uuid, String username) {
		this.uuid = uuid;
		this.username = username;
	}
}
