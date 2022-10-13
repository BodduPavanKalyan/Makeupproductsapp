package com.example.MakeupProducts.repository
import com.example.MakeupProducts.model.DataUsed
import com.example.MakeupProducts.retroData.ApiImplement
import com.example.MakeupProducts.roomDb.RoomDaoImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

//injecting apiImplement and roomDaoImp as constructor here
class DataRepo @Inject constructor(private val apiImplement: ApiImplement, private val roomDaoImp: RoomDaoImp) {

    fun getPost1(): kotlinx.coroutines.flow.Flow<List<DataUsed>> = flow {
        var getList = roomDaoImp.getRetroinfo()
        if(getList.size > 0){
            emit(getList)
        }
        else{
            val response = apiImplement.getPost()
            roomDaoImp.insertRetroInfo(response)
            getList = roomDaoImp.getRetroinfo()
            emit(getList)
        }

    }.flowOn(Dispatchers.IO)

}
