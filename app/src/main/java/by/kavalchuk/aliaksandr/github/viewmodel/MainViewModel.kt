package by.kavalchuk.aliaksandr.github.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kavalchuk.aliaksandr.github.data.network.model.GitList
import by.kavalchuk.aliaksandr.github.data.network.model.GitUsers
import by.kavalchuk.aliaksandr.github.data.network.model.Item
import by.kavalchuk.aliaksandr.github.data.network.repository.GitRepository
import by.kavalchuk.aliaksandr.github.utils.StateResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val repository: GitRepository
): ViewModel() {

    private val _liveDataList: MutableLiveData<List<Item>> = MutableLiveData()
    val liveDataList: LiveData<List<Item>>
        get() = _liveDataList

    private val _searchResults: MutableLiveData<GitUsers> = MutableLiveData()
    val searchResults: LiveData<GitUsers>
        get() = _searchResults

    suspend fun loadListOfData() {
        viewModelScope.launch {
            when (val resultResponse = repository.makeApiSearchResponse("fel")) {
                is StateResult.Success -> {
                    val latestNews = resultResponse.data
                    _liveDataList.postValue(latestNews.items)
                }
                is StateResult.Error -> {
//                    Timber.e("Error in response ${resultResponse.exception.localizedMessage}")
                }
                else -> {

                }
            }
        }
    }

    suspend fun loadListOfSearchUsers(user: String) {
        viewModelScope.launch {
            when (val resultResponse = repository.makeApiUserResponse(user)) {
                is StateResult.Success -> {
                    val latestNews = resultResponse.data
                    _searchResults.postValue(latestNews)
                }
                is StateResult.Error -> {
//                    Timber.e("Error in response ${resultResponse.exception.localizedMessage}")
                }
                else -> {

                }
            }
        }
    }














}