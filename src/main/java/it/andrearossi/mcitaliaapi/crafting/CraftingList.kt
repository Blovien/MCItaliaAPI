package it.andrearossi.mcitaliaapi.crafting

import it.andrearossi.mcitaliaapi.utils.html.JsonCategoryList

class CraftingList(status: String?, items: Array<Crafting?>?, categories: Array<CraftingCategory?>?) : JsonCategoryList<Crafting?, CraftingCategory?>(status!!, items!!, categories!!) 