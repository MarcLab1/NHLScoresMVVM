package com.nhlscores.model

data class Games(
    val games: List<Game>,
    val lastUpdatedOn: String,
    val references: References?
)