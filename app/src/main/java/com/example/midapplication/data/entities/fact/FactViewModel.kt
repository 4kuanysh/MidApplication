package com.example.midapplication.data.entities.fact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.midapplication.data.entities.Result
import com.example.midapplication.data.entities.fact.repo.FactRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class FactViewModel(private val repository: FactRepository): ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    private val mFactsLiveData = MutableLiveData<Result<List<FactResponse.All>>>()
    val factLiveData get() = mFactsLiveData

    fun loadFacts() {
        launch {
            try {
                mFactsLiveData.value = Result.Success(repository.getFacts())
            } catch (e: Exception) {
                mFactsLiveData.value = Result.Error
            }
        }
    }

    fun insertFacts(data: List<FactResponse.All>) {
        launch {
            repository.insertFacts(data)
        }
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}