package com.nhlscores.model

data class VenueReference(
    val baseballDimensions: List<Any>,
    val capacitiesByEventType: List<CapacitiesByEventType>,
    val city: String,
    val country: String,
    val geoCoordinates: GeoCoordinates,
    val hasRetractableRoof: Boolean,
    val hasRoof: Boolean,
    val id: Int,
    val name: String,
    val playingSurface: Any
)