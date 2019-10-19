package com.example.midapplication.data.network

import com.example.midapplication.data.entities.fact.FactResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CatFactApi {

    @GET("facts/")
    fun getFactsAsync(): Deferred<FactResponse>
}