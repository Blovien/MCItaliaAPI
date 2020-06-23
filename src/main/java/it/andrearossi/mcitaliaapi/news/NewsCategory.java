package it.andrearossi.mcitaliaapi.news;

public class NewsCategory {

    private final byte id;

    private final String name;

    public NewsCategory(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte getId() {
        return id;
    }
}
