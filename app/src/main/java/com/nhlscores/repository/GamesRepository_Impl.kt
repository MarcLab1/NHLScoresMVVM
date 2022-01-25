package com.nhlscores.repository

import com.nhlscores.model.Game
import com.nhlscores.model.Games
import com.nhlscores.network.ApiService
import com.nhlscores.network.dto.DtoMapper
import com.nhlscores.utils.Resource
import javax.inject.Inject

class GamesRepository_Impl
 @Inject constructor(private val apiService : ApiService, val dtoMapper: DtoMapper)
 : GamesRepository
{
    override suspend fun getGamesByDate(date: String): Resource<Games> {
        val response = try {
            dtoMapper.mapToDomainModel(apiService.getGamesByDate(date))
        }
        catch (e : Exception)
        {
            return Resource.Error("I am error")
        }
        return Resource.Success(response)
    }
}