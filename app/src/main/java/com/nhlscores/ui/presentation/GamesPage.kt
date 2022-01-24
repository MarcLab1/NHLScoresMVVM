package com.nhlscores.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.nhlscores.model.Game
import com.nhlscores.utils.Constants

@Composable
fun GamesPage(nav: NavController, vm: MyViewModel) {
    //var vm: MyViewModel = viewModel()

    LazyColumn()
    {

        if (vm.games.value != null) {
            if (vm.games.value!!.games.isEmpty()) {
                item()
                {
                    NoGamesPage()
                }
            } else {
                items(vm.games.value!!.games)
                { game ->
                    Game(nav, game, vm)
                }
            }
        }
    }
}

@Composable
fun NoGamesPage() {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text("No Games")
    }
}

@Composable
fun Game(nav: NavController, game: Game, vm: MyViewModel) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
                start = 6.dp,
                end = 6.dp
            )
            .fillMaxWidth()
            .clickable {
                vm.currentGame.value = game
                nav.navigate("game")
            },
        elevation = 8.dp,
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ) {

            CustomGameRow(
                game.schedule.awayTeam.abbreviation,
                Constants.getTeamImageUrl(game.schedule.awayTeam.abbreviation.lowercase()),
                game.score.awayScoreTotal.toString(),
                game.score.awayScoreTotal > game.score.homeScoreTotal
            )

            CustomGameRow(
                game.schedule.homeTeam.abbreviation,
                Constants.getTeamImageUrl(game.schedule.homeTeam.abbreviation.lowercase()),
                game.score.homeScoreTotal.toString(),
                game.score.homeScoreTotal > game.score.awayScoreTotal
            )
        }
    }
}

@Composable
fun CustomGameRow(abbreviation: String, imageUrl: String, score: String, winner: Boolean) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .wrapContentWidth(Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painter = rememberImagePainter(imageUrl),
                "logo",
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .padding(end = 10.dp)
            )
            Text(
                "${abbreviation}",
                style = if (winner) MaterialTheme.typography.body2
                else MaterialTheme.typography.body1
            )
        }
        Text(
            "${score}", modifier = Modifier
                .wrapContentWidth(Alignment.End)
                .align(Alignment.CenterVertically),
            style = if (winner) MaterialTheme.typography.body2
            else MaterialTheme.typography.body1
        )

    }
}

