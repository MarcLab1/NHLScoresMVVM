package com.nhlscores.network

import com.nhlscores.model.Game
import com.nhlscores.model.References

data class GamesDto(
    val games: List<Game>,
    val lastUpdatedOn: String,
    val references: References?
)