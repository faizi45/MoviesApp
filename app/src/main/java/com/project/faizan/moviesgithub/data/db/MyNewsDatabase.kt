package com.project.faizan.moviesgithub.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

/**
add entities with comma separated in entities array below
@Database(
entities = [RegisterDeviceDto::class],
version = 1
)*/
abstract class MyNewsDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: MyNewsDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MyNewsDatabase::class.java, "cellcard_music.db"
        ).build()
    }
}