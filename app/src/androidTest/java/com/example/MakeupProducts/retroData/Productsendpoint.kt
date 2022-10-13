package com.example.MakeupProducts.retroData

import com.example.MakeupProducts.model.DataUsed
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface Productsendpoint {
    @GET("api/v1/products.json?brand=maybelline")
    fun getitems(): Call<Response<DataUsed>>
}