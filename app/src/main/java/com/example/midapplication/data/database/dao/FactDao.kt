package com.example.midapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.midapplication.data.entities.fact.FactResponse

@Dao
interface FactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFacts(facts: List<FactResponse.All>)

    @Query("SELECT * FROM `All`")
    fun getFacts(): List<FactResponse.All>

}