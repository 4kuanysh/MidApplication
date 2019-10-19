package com.example.midapplication.data.entities.fact
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class FactResponse(
    @SerializedName("all")
    val all: List<All>
) {
    @Entity(tableName = "All")
    data class All(
        @PrimaryKey
        @SerializedName("_id")
        val id: String,
        @SerializedName("text")
        @ColumnInfo(name = "text")
        val text: String,
        @SerializedName("type")
        @ColumnInfo(name = "type")
        val type: String,
        @SerializedName("upvotes")
        @ColumnInfo(name = "upvotes")
        val upvotes: Int
    )
}