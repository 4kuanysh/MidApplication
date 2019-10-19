package com.example.midapplication.data.entities.fact.repo

import com.example.midapplication.data.database.dao.FactDao
import com.example.midapplication.data.entities.fact.FactResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalFactRepoImpl(private val factDao: FactDao):
    FactRepository {
    override suspend fun getFacts(): List<FactResponse.All> {
        return withContext(Dispatchers.IO) {
            factDao.getFacts()
        }
    }
    override suspend fun insertFacts(facts: List<FactResponse.All>) {
        withContext(Dispatchers.IO) {
            factDao.insertFacts(facts)
        }
    }

}