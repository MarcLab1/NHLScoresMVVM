package com.nhlscores.repository

import com.nhlscores.model.Games
import com.nhlscores.network.ApiService

interface GamesRepository  {

    suspend fun getGamesByDate(date : String) : Games
}