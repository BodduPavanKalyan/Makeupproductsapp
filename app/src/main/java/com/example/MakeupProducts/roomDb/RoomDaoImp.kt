package com.example.MakeupProducts.roomDb

import com.example.MakeupProducts.model.DataUsed
import javax.inject.Inject

class RoomDaoImp @Inject constructor(private val roomDao: RoomDao) {
    suspend fun getRetroinfo():List<DataUsed> = roomDao.getALL()

    suspend fun insertRetroInfo(Data :List<DataUsed>) = roomDao.insertRetroData(Data)

}