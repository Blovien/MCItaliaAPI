package it.andrearossi.mcitaliaapi.crafting;

import it.andrearossi.mcitaliaapi.utils.html.JsonCategory;

public class CraftingCategory extends JsonCategory {

    private final byte position;

    public CraftingCategory(short id, byte position, String name, String url) {
        super(id, name, url);

        this.position = position;
    }

    public byte getPosition() {
        return position;
    }
}
