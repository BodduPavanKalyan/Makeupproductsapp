package com.example.MakeupProducts.retroData

import org.junit.Assert.*
import org.junit.Test
import retrofit2.Retrofit

class ProductretrofitTest{
    @Test
    fun testRetrofitInstance(){
        val instance: Retrofit = Productretrofit().retrofit
        assert(instance.baseUrl().toString() == "https://makeup-api.herokuapp.com/")
    }
//    @Test
//    fun testMemesService(){
//        val service =ProductService(Productretrofit().retrofit)
//        val response = service.getitems().execute()
//        val errorBody = response.errorBody()
//        assert(errorBody == null)
//
//        //Check for success body
//        val responseWrapper = response.body()
//        assert(responseWrapper != null)
//        assert(response.code() == 200)
//    }

}