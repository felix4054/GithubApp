package by.kavalchuk.aliaksandr.github.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import by.kavalchuk.aliaksandr.github.components.GitIListItem
import by.kavalchuk.aliaksandr.github.components.GitUserListItem
import by.kavalchuk.aliaksandr.github.components.SearchView
import by.kavalchuk.aliaksandr.github.components.TopBar
import by.kavalchuk.aliaksandr.github.data.network.model.GitUsers
import by.kavalchuk.aliaksandr.github.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {

    val allGit = mainViewModel.liveDataList.observeAsState(listOf()).value
//    Log.d("allGit", "Load git repository: $allGit")
    val searchResults = mainViewModel.searchResults.observeAsState().value
    Log.d("allGit", "Load git user: $searchResults")

    val textState = remember { mutableStateOf(TextFieldValue("")) }
    var searching by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("felix4054") }
    var isButtonEnable by remember { mutableStateOf(false) }

//    fun getItemCount(): Int {
//        return  allGit.size
//    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row() {
                TopBar()
            }
        },
        content = {
            Column(
//                modifier = Modifier
//                    .padding(16.dp)
            ) {
                SearchView(textState)

                if (searchResults != null) {
                    GitUserListItem(item = searchResults, navController = navController)
                }

                LaunchedEffect(true) {
                    mainViewModel.loadListOfData()
                    mainViewModel.loadListOfSearchUsers(title)
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
    )
}