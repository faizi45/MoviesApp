package com.project.faizan.mynewsapp.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


object IdsListConverter {
    var gson = Gson()

    @TypeConverter
    @JvmStatic
    fun stringToLongList(data: String?): List<Long> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Long>>() {

        }.getType()

        return gson.fromJson<List<Long>>(data, listType)
    }

    @TypeConverter
    @JvmStatic
    fun longListToString(someObjects: List<Long>): String {
        return gson.toJson(someObjects)
    }
}