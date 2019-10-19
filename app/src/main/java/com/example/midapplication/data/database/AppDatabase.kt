package com.example.midapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.midapplication.data.entities.fact.FactResponse
import com.example.midapplication.data.database.dao.FactDao

@Database(entities = [FactResponse.All::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getFactDao(): FactDao

    companion object {
        const val DB_NAME = "mid.db"
    }
}