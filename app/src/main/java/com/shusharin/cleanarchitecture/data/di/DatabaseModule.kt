package com.shusharin.cleanarchitecture.data.di

import android.app.Application
import androidx.room.Room
import com.shusharin.cleanarchitecture.data.database.DAO
import com.shusharin.cleanarchitecture.data.database.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
    ): Database {
        return Room
            .databaseBuilder(application, Database::class.java, "Product.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(database: Database): DAO {
        return database.dao()
    }

}