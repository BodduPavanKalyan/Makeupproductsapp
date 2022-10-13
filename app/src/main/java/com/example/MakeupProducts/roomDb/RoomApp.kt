package com.example.MakeupProducts.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.MakeupProducts.model.DataUsed
//just creating a database here to store the data
@Database(entities = [DataUsed::class], version = 1)
abstract class RoomApp :RoomDatabase() {
    abstract fun deo():RoomDao
companion object {
    private var INSTANCE : RoomApp? = null
    fun getDataBase(context: Context):RoomApp{
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                context,
                RoomApp::class.java,
                "RoomInfo"
            ).build()
        }
        return INSTANCE!!
    }


}

}