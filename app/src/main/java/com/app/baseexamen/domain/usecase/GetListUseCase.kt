package com.app.baseexamen.domain.usecase

import com.app.baseexamen.domain.model.CountryData
import com.app.baseexamen.domain.common.Result
import com.app.baseexamen.domain.repository.BaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetByCountryUseCase @Inject constructor(
    private val repository: BaseRepository
) {
    operator fun invoke(country: String): Flow<Result<CountryData>> =
        flow {
            emit(Result.Loading)

                        try {
                            val response = repository.getByCountry(country)
                            val filteredCases = response.cases.filter {
                                it.total != 0 || it.new != 0
                            }

                            val cleanedData = response.copy(
                                cases = filteredCases
                            )

                            emit(Result.Success(cleanedData))
                        } catch (e: Exception) {
                            emit(Result.Error(e))
                        }
                    }
            }


