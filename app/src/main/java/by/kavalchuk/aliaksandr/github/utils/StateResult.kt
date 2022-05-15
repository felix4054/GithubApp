package by.kavalchuk.aliaksandr.github.utils

import by.kavalchuk.aliaksandr.github.data.network.model.GitList
import by.kavalchuk.aliaksandr.github.data.network.model.Item


sealed class StateResult<out T : Any> {
    class Success<out T : Any>(val data: T) : StateResult<T>()
    class Error(val exception: Exception) : StateResult<Nothing>()
    class Loading<T>() : StateResult<Nothing>()
}