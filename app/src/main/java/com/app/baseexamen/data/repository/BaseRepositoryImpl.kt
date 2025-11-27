package com.app.baseexamen.data.repository

import com.app.baseexamen.data.mapper.toDomain
import com.app.baseexamen.data.remote.api.BaseApi
import com.app.baseexamen.data.remote.dto.CountryDataDto
import com.app.baseexamen.domain.model.CountryData
import com.app.baseexamen.domain.repository.BaseRepository
import retrofit2.Response

class BaseRepositoryImpl(private val api: BaseApi) : BaseRepository {

    override suspend fun getByCountry(country: String): Result<List<CountryData>> {
        return try {
            val response: Response<List<CountryDataDto>> = api.getByCountry(country)
            if (response.isSuccessful) {
                val dtoList = response.body() ?: emptyList()
                Result.success(dtoList.toDomain())
            } else {
                Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /*override suspend fun getByDate(date: String): Result<List<CountryData>> {
        return try {
            val response: Response<List<CountryDataDto>> = api.getByDate(date)
            if (response.isSuccessful) {
                val dtoList = response.body() ?: emptyList()
                Result.success(dtoList.toDomain())
            } else {
                Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }*/
}