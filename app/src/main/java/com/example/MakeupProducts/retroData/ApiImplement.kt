package com.example.MakeupProducts.retroData

import com.example.MakeupProducts.model.DataUsed
import javax.inject.Inject
//implementing the api by injecting apiInterface as a constructor
class ApiImplement @Inject constructor(private val apiInterface: ApiInterface) {

suspend fun getPost():List<DataUsed> = apiInterface.getPost()
}