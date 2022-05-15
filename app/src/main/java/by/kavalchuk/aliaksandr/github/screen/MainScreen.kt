package by.kavalchuk.aliaksandr.github.screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import by.kavalchuk.aliaksandr.github.components.GitIListItem
import by.kavalchuk.aliaksandr.github.components.TopBar
import by.kavalchuk.aliaksandr.github.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {

    val allGit = mainViewModel.liveDataList.observeAsState(listOf()).value
    Log.d("allGit", "Load git repository: $allGit")

    fun getItemCount(): Int {
        return  allGit.size
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar()
        },
    ) {
        LaunchedEffect(true) {
            mainViewModel.loadListOfData()
        }
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
        ) {
            items(allGit) { item ->
                GitIListItem(item = item, navController = navController)
            }
        }
    }
}