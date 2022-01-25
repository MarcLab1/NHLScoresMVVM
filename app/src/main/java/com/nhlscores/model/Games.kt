package com.nhlscores.model

import com.nhlscores.network.dto.References

data class Games(
    val games: List<Game>,
    val lastUpdatedOn: String,
    val references: References?
)