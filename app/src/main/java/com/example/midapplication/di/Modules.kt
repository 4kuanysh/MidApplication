package com.example.midapplication.di

import androidx.room.Room
import com.example.midapplication.data.database.AppDatabase
import com.example.midapplication.data.database.dao.FactDao
import com.example.midapplication.data.entities.fact.repo.RemoteFactRepoImpl
import com.example.midapplication.data.entities.fact.FactViewModel
import com.example.midapplication.data.entities.fact.repo.LocalFactRepoImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dbModule = module {
    single { Room.databaseBuilder(androidContext(),
        AppDatabase::class.java, AppDatabase.DB_NAME).build() }

    single { get<AppDatabase>().getFactDao() }
}

val repoModule = module {
    single { RemoteFactRepoImpl() }
    single { LocalFactRepoImpl(get() as FactDao) }
}

val viewModelModule = module {
    viewModel (named("RemoteFactViewModel")){ FactViewModel(get() as RemoteFactRepoImpl) }
    viewModel (named("LocalFactViewModel")){ FactViewModel(get() as LocalFactRepoImpl) }
}
