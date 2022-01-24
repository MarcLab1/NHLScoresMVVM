package com.nhlscores.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.nhlscores.model.Game
import com.nhlscores.utils.Constants

@Composable
fun GameDetailPage(game: Game) {
    LazyColumn()
    {
        item()
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            ) {

                CustomGameDetailColumn(
                    modifier = Modifier.fillMaxWidth(.4f),
                    teamAbbreviation = game.schedule.awayTeam.abbreviation,
                    imageUrl = Constants.getTeamImageUrl(game.schedule.awayTeam.abbreviation.lowercase()),
                    goals = game.score.awayScoreTotal.toString(),
                    shots = game.score.awayShotsTotal.toString()
                )
                CustomGameDetailColumn(
                    modifier = Modifier.fillMaxWidth(.333f),
                    teamAbbreviation = "",
                    imageUrl = "",
                    goals = "Goals",
                    shots = "Shots"
                )
                CustomGameDetailColumn(
                    modifier = Modifier.fillMaxWidth(),
                    teamAbbreviation = game.schedule.homeTeam.abbreviation,
                    imageUrl = Constants.getTeamImageUrl(game.schedule.homeTeam.abbreviation.lowercase()),
                    goals = game.score.homeScoreTotal.toString(),
                    shots = game.score.homeShotsTotal.toString(),
                )
            }
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text("Attendance: ${game.schedule.attendance.toString()}", modifier = Modifier.padding(top = 30.dp, bottom = 10.dp))
            }
        }
    }
}

@Composable
fun CustomGameDetailColumn(modifier: Modifier, teamAbbreviation: String, imageUrl: String, goals: String, shots: String)
{
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            teamAbbreviation,
            modifier = Modifier.padding(bottom = 10.dp)
        )
       Image(
                painter = rememberImagePainter(imageUrl),
                "logo",
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .padding(bottom = 10.dp)
        )
        Text(
            goals,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            shots,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}

