package it.andrearossi.mcitaliaapi.utils.html

open class JsonCategoryList<T : APIObject?, K : JsonCategory?>(status: String, items: Array<T>, val categories: Array<K>) : JsonList<T>(status, items)