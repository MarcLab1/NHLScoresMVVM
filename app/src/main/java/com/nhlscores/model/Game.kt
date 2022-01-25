package com.nhlscores.model

import com.nhlscores.network.dto.Schedule
import com.nhlscores.network.dto.Score

data class Game(
    val schedule: Schedule,
    val score: Score
)