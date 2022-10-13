package com.example.MakeupProducts.retroData

import com.example.MakeupProducts.model.DataUsed
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class  ProductService  constructor(private val retrofit : Retrofit): Productsendpoint {
    private val endpoint by lazy {  retrofit.create(Productsendpoint::class.java)  }
    override fun getitems() : Call<Response<DataUsed>> {
        return endpoint.getitems()
    }
}