package com.app.baseexamen.domain.repository

import com.app.baseexamen.domain.model.Case
import com.app.baseexamen.domain.model.CountryData

interface BaseRepository {
    suspend fun getByCountry(country: String): Result<List<CountryData>>
    suspend fun getByDate(date: String): Result<List<CountryData>>
}