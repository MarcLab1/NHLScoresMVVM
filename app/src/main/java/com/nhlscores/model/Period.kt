package com.nhlscores.model

data class Period(
    val awayScore: Int,
    val awayShots: Int,
    val homeScore: Int,
    val homeShots: Int,
    val periodNumber: Int
)