package com.nhlscores.network

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    //20211012/games.json
    @GET ("date/{date}/games.json")
    suspend fun getGamesByDate(
        @Path("date") date: String) : GamesDto
}