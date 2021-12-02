package com.shusharin.cleanarchitecture.data.datasource.local

import com.shusharin.cleanarchitecture.data.database.Database
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val database: Database) : LocalDataSource {
    override fun method() {
        database.method()
    }
}