package com.example.MakeupProducts.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
//creating a table of data
@Entity(tableName = "RoomDB")

//This is the data we have used for our design

data class DataUsed(
    @PrimaryKey(autoGenerate = true)

    @SerializedName("id")
    val id :Int,
    @SerializedName("brand")
    val brand : String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image_link")
    val image_link : String,
    @SerializedName("description")
    val description :String
)
