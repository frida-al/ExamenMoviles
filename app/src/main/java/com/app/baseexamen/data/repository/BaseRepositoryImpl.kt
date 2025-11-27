package com.app.baseexamen.data.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseRepositoryImpl @Inject constructor(
    private val api: BaseApi,
) : BaseRepository{

}