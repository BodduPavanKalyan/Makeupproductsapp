package com.example.MakeupProducts.retroData

import com.example.MakeupProducts.model.DataUsed
import retrofit2.http.GET

interface ApiInterface {
@GET("api/v1/products.json?brand=maybelline")
suspend fun getPost(): List<DataUsed>

}