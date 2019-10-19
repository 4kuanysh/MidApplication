package com.example.midapplication.data.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatFactService {
    const val BASE_URL = "https://cat-fact.herokuapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()


    val api: CatFactApi = retrofit.create(CatFactApi::class.java)
}