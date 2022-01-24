package com.nhlscores.model

data class Weather(
    val description: String,
    val humidityPercent: Int,
    val precipitation: Precipitation,
    val temperature: Temperature,
    val type: String,
    val wind: Wind
)