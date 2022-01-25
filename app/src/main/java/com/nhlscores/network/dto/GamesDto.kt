package com.nhlscores.network.dto

import com.nhlscores.model.Game

data class GamesDto(
    val games: List<Game>,
    val lastUpdatedOn: String,
    val references: References?
)