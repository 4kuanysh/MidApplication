package com.example.midapplication.data.entities.fact.repo

import com.example.midapplication.data.database.dao.FactDao
import com.example.midapplication.data.entities.fact.FactResponse
import com.example.midapplication.data.network.CatFactService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteFactRepoImpl: FactRepository {
    override suspend fun insertFacts(facts: List<FactResponse.All>) {}

    override suspend fun getFacts(): List<FactResponse.All> {
        return withContext(Dispatchers.IO) {
            CatFactService.api.getFactsAsync().await().all
        }
    }

}