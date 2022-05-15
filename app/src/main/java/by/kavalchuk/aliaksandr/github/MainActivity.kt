package by.kavalchuk.aliaksandr.github

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import by.kavalchuk.aliaksandr.github.navigation.AppNavHost
import by.kavalchuk.aliaksandr.github.screen.MainScreen
import by.kavalchuk.aliaksandr.github.ui.theme.GitHubTheme
import by.kavalchuk.aliaksandr.github.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val mainViewModel = hiltViewModel<MainViewModel>()
                    AppNavHost(navController = navController, mainViewModel = mainViewModel)

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GitHubTheme {
        MainScreen(
            navController = rememberNavController(),
            mainViewModel = hiltViewModel()
        )
    }
}