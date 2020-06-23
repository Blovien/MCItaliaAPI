package it.andrearossi.mcitaliaapi.requests.connection

import it.andrearossi.mcitaliaapi.MCItaliaAPI
import it.andrearossi.mcitaliaapi.utils.RunnableVal
import java.io.IOException
import java.lang.reflect.InvocationTargetException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

open class HttpConnection<T>(private var url: String?, private val userAgent: String, private val version: String, t: Class<T>) {
    private var connection: HttpURLConnection? = null
    var value: T? = null
        private set
    private val exceptionHandler = MCItaliaAPI.getExceptionHandler()

    constructor(url: String?, t: Class<T>) : this(url, "Mozilla", "5.0", t)

    private fun connect() {
        try {
            connection = toURL().openConnection() as HttpURLConnection
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getRunnable(runnable: RunnableVal<HttpURLConnection?, T>): T? {
        try {
            connection!!.requestMethod = "GET"
            connection!!.setRequestProperty("User-Agent", "$userAgent/$version")
            if (connection!!.responseCode == HttpURLConnection.HTTP_OK) runnable.run(connection)
        } catch (e: IOException) {
            exceptionHandler.exception(e).handle()
        }
        return value
    }

    fun postRunnable(runnable: RunnableVal<HttpURLConnection?, T>, param: String): T? {
        try {
            connection!!.requestMethod = "POST"
            connection!!.setRequestProperty("User-Agent", "$userAgent/$version")
            connection!!.doOutput = true
            val stream = connection!!.outputStream
            stream.write(param.toByteArray())
            stream.flush()
            stream.close()
            if (connection!!.responseCode == HttpURLConnection.HTTP_OK) runnable.run(connection)
        } catch (e: IOException) {
            exceptionHandler.exception(e).handle()
        }
        return value
    }

    @Throws(MalformedURLException::class)
    fun toURL(): URL {
        return URL(url)
    }

    fun setURL(url: String?) {
        this.url = url
    }

    fun setValue(t: T) {
        value = t
    }

    init {
        try {
            value = t.getDeclaredConstructor().newInstance()
        } catch (e: InstantiationException) {
            exceptionHandler.exception(e).handle()
        } catch (e: IllegalAccessException) {
            exceptionHandler.exception(e).handle()
        } catch (e: InvocationTargetException) {
            exceptionHandler.exception(e).handle()
        } catch (e: NoSuchMethodException) {
            exceptionHandler.exception(e).handle()
        }
        connect()
    }
}