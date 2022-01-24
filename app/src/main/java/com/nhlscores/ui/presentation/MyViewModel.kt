package com.nhlscores.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhlscores.model.Game
import com.nhlscores.model.Games
import com.nhlscores.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    val repository: GamesRepository,
    val string: String
) : ViewModel() {

    var games: MutableState<Games?> = mutableStateOf(null)
    var dateString: MutableState<String> = mutableStateOf("")
    var dateLong: MutableState<Long> = mutableStateOf(0)

    var day = mutableStateOf(12)
    var month = mutableStateOf(9)
    var year = mutableStateOf(2021)
    var maxDateLong: MutableState<Long> = mutableStateOf(0)
    var minDateLong: MutableState<Long> = mutableStateOf(0)
    var maxDateString: MutableState<String> = mutableStateOf("")
    var minDateString: MutableState<String> = mutableStateOf("")

    var currentGame : MutableState<Game?> = mutableStateOf(null)

    init {
        initMinMaxDate()
        loadGames(year.value, month.value, day.value)
    }

    fun loadGames(y: Int, m: Int, d: Int) {
        populateDateLong(y,m,d)
        loadGames()
    }

    fun loadGames() {
        viewModelScope.launch {
            games.value = repository.getGamesByDate(dateString.value)
        }
    }

    private fun populateDateLong(y: Int, m: Int, d: Int) {
        dateLong.value = getLongFromYMD(y, m, d)
        populateDateString()
    }

    private fun populateDateString()
    {
        dateString.value = getStringFromLong(dateLong.value)
        var date = DateTime(dateLong.value)
        year.value = date.year
        month.value = date.monthOfYear - 1
        day.value = date.dayOfMonth
    }

    fun changeDateByOne(flag: Boolean): Unit {
        if(flag)
            dateLong.value = dateLong.value + TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)
        else
            dateLong.value = dateLong.value - TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)

        populateDateString()
    }

    private fun getLongFromYMD(year: Int, month: Int, day: Int): Long {
        var dateTime = DateTime(year, month + 1, day, 0, 0, 0);
        return dateTime.getMillis();
    }

    private fun getStringFromLong(date: Long): String {
        var sdf = SimpleDateFormat("yyyyMMdd")
        return sdf.format(date)
    }

    private fun getStringFromYMD(year: Int, month: Int, day: Int): String {
        var date = getLongFromYMD(year, month, day)
        return getStringFromLong(date)
    }

    private fun initMinMaxDate(): Unit {
        minDateString.value = getStringFromYMD(2021, 9, 12)
        minDateLong.value = getLongFromYMD(2021, 9, 12)
        maxDateString.value = getStringFromYMD(2022, 5, 30)
        maxDateLong.value = getLongFromYMD(2022, 5, 30)
    }
    fun getFormattedDateEEEMMMdyyyy(): String {
        var sdf = SimpleDateFormat("EEE MMM d, yyyy")
        return sdf.format(dateLong.value)
    }
}