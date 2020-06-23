package it.andrearossi.mcitaliaapi.utils.html

open class JsonList<T : APIObject?>(val status: String, val items: Array<T>) : APIObject 