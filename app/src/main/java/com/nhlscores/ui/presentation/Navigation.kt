package com.nhlscores.ui.presentation


import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.nhlscores.model.TestItem

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

@Composable
fun TestItemPage(item : TestItem)
{
    Column() {
        Text(item.id.toString())
        Text(item.name.toString())
    }
}
