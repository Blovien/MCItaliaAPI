package it.andrearossi.mcitaliaapi.utils.html;

public class JsonCategory implements APIObject {

    private final short id;

    private final String name;

    private final String url;

    public JsonCategory(short id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
