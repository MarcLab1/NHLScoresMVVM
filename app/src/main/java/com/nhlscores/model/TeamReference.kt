package com.nhlscores.model

data class TeamReference(
    val abbreviation: String,
    val city: String,
    val homeVenue: HomeVenue,
    val id: Int,
    val name: String,
    val officialLogoImageSrc: String,
    val socialMediaAccounts: List<SocialMediaAccount>,
    val teamColoursHex: List<String>
)