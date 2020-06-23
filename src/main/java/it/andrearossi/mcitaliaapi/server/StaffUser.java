package it.andrearossi.mcitaliaapi.server;

import it.andrearossi.mcitaliaapi.utils.Constants;
import it.andrearossi.mcitaliaapi.utils.html.APIObject;

public class StaffUser implements APIObject {

    private final String uuid;
    private final String username;

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
