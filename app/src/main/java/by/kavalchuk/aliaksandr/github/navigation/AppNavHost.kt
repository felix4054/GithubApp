package by.kavalchuk.aliaksandr.github.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.kavalchuk.aliaksandr.github.screen.MainScreen
import by.kavalchuk.aliaksandr.github.viewmodel.MainViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {

    NavHost(
    navController = navController,
    startDestination = Screens.Main.route
    ) {
        composable(route = Screens.Main.route) {
            MainScreen(
                navController = navController,
                mainViewModel = mainViewModel
            )
        }
    }
}