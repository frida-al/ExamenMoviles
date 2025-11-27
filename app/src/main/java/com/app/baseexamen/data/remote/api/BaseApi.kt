package com.app.baseexamen.data.remote.api

import com.app.baseexamen.data.remote.dto.CountryDataDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseApi {

    @GET("v1/covid19")
    suspend fun getByCountry(
        @Query("country") country: String,
        ) : Response<List<CountryDataDto>>

    @GET("v1/covid19")
    suspend fun getByDate(
        @Query("date") date: String
    ) : Response<List<CountryDataDto>>
}
