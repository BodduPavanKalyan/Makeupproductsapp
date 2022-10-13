package com.example.MakeupProducts.roomDb


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.MakeupProducts.model.DataUsed


@Dao
interface RoomDao {
@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertRetroData(retroData:List<DataUsed>)
@Query("SELECT * FROM RoomDB")
suspend fun getALL():List<DataUsed>


}