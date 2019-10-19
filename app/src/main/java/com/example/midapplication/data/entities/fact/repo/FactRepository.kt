package com.example.midapplication.data.entities.fact.repo

import com.example.midapplication.data.entities.fact.FactResponse

interface FactRepository {
    suspend fun getFacts(): List<FactResponse.All>
    suspend fun insertFacts(facts: List<FactResponse.All>)

//    interface LocalFactRepository: FactRepository {
//        suspend fun insertFacts(facts: List<FactResponse.All>)
//    }
}