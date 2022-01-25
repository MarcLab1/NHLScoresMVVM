package com.nhlscores.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nhlscores.network.dto.TestItem

@Composable
fun Navigation() {

    var nav = rememberNavController()
    var vm: MyViewModel = viewModel()

    NavHost(navController = nav, startDestination = "home")
    {
        composable("home")
        {
            Column()
            {
                DatePickerPage(vm)
                GamesPage(nav, vm)
            }
        }
        composable("game")
        {
            vm.currentGame.value?.let { it1 -> GameDetailPage(it1) }
        }
    }
}
