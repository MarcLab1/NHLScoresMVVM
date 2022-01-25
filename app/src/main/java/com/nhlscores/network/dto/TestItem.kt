package com.nhlscores.network.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestItem(val id: Int, val name: String) : Parcelable