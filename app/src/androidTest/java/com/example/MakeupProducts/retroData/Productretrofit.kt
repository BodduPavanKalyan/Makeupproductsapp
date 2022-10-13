package com.example.MakeupProducts.retroData

import com.example.MakeupProducts.dependencyInjection.Dependency.providBaseUrl
import hilt_aggregated_deps._com_example_MakeupProducts_dependencyInjection_Dependency
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Productretrofit {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://makeup-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}