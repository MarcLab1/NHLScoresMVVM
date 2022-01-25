package com.nhlscores.network.dto

data class Schedule(
    val attendance: Int,
    val awayTeam: AwayTeam,
    val broadcasters: List<String>,
    val delayedOrPostponedReason: Any,
    val endedTime: Any,
    val homeTeam: HomeTeam,
    val id: Int,
    val officials: List<Official>,
    val originalStartTime: Any,
    val playedStatus: String,
    val scheduleStatus: String,
    val startTime: String,
    val venue: Venue,
    val venueAllegiance: String,
    val weather: Weather
)