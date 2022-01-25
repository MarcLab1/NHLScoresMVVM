package com.nhlscores.repository

import com.nhlscores.model.Games
import com.nhlscores.network.ApiService
import com.nhlscores.utils.Resource

interface GamesRepository  {

    suspend fun getGamesByDate(date : String) : Resource<Games>
}