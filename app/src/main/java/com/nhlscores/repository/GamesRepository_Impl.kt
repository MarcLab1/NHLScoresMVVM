package com.nhlscores.repository

import com.nhlscores.model.Games
import com.nhlscores.network.ApiService
import com.nhlscores.network.DtoMapper
import javax.inject.Inject

class GamesRepository_Impl
 @Inject constructor(val apiService : ApiService, val dtoMapper: DtoMapper)
 : GamesRepository
{
    override suspend fun getGamesByDate(date: String): Games {
        return dtoMapper.mapToDomainModel(apiService.getGamesByDate(date))
    }
}