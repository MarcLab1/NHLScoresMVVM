package com.nhlscores.network.dto

data class Score(
    val awayScoreTotal: Int,
    val awayShotsTotal: Int,
    val currentIntermission: Any,
    val currentPeriod: Any,
    val currentPeriodSecondsRemaining: Any,
    val homeScoreTotal: Int,
    val homeShotsTotal: Int,
    val periods: List<Period>
)