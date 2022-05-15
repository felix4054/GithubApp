package by.kavalchuk.aliaksandr.github.navigation

import by.kavalchuk.aliaksandr.github.utils.Constants.Screens.DETAILS_SCREEN
import by.kavalchuk.aliaksandr.github.utils.Constants.Screens.MAIN_SCREEN
import by.kavalchuk.aliaksandr.github.utils.Constants.Screens.SPLASH_SCREEN

sealed class Screens(val route: String) {
    object Splash: Screens(route = SPLASH_SCREEN)
    object Main: Screens(route = MAIN_SCREEN)
    object Details: Screens(route = DETAILS_SCREEN)
}