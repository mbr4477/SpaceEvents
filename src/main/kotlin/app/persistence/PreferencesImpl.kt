package app.persistence

import entity.persistence.IPreferences
import java.util.prefs.Preferences

object PreferencesImpl : IPreferences {
    private val preferences = Preferences.userNodeForPackage(PreferencesImpl::class.java)
    private val separator = "&"

    init {
        preferences.clear()
    }

    override fun getStringList(key: String): List<String> {
        return preferences.get(key, "").split(separator)
    }

    override fun putStringList(key: String, stringList: List<String>) {
        preferences.put(key, stringList.joinToString(separator))
    }
}