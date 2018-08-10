package com.matthewrussell.spaceevents.entity.persistence

interface IPreferences {
    fun getStringList(key: String): List<String>
    fun putStringList(key: String, stringList: List<String>)
}