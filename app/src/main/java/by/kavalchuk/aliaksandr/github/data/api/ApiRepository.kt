package by.kavalchuk.aliaksandr.github.data.api

import androidx.lifecycle.MutableLiveData
import by.kavalchuk.aliaksandr.github.data.network.model.GitList
import by.kavalchuk.aliaksandr.github.data.network.model.GitUsers
import by.kavalchuk.aliaksandr.github.data.network.model.Item
import by.kavalchuk.aliaksandr.github.utils.StateResult


interface ApiRepository{
    suspend fun makeApiSearchResponse(query: String): StateResult<GitList>
    suspend fun makeApiUserResponse(user: String): StateResult<GitUsers>
}