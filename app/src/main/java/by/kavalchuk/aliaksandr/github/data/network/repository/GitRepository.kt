package by.kavalchuk.aliaksandr.github.data.network.repository

import by.kavalchuk.aliaksandr.github.data.api.ApiRepository
import by.kavalchuk.aliaksandr.github.data.api.ApiService
import by.kavalchuk.aliaksandr.github.data.network.model.GitList
import by.kavalchuk.aliaksandr.github.utils.StateResult
import javax.inject.Inject

class GitRepository @Inject constructor(private val apiService: ApiService) : ApiRepository {

    override suspend fun makeApiCall(query: String): StateResult<GitList> {
        try {
            val dataResponse = apiService.getDataFromApiAsync(query)
            var newsResponse: GitList? = null
            when {
                dataResponse.isSuccessful -> {
//                    Timber.e("SUCCESS RESP ${Gson().toJson(dataResponse.body())}")
                    newsResponse = dataResponse.body()
                }
                else -> {
//                    Timber.e("ERROR RESP ${Gson().toJson(dataResponse.errorBody())}")
                }
            }
            return StateResult.Success(newsResponse!!)

        } catch (exception: Exception) {

            val errorResponse = StateResult.Error(exception)
//            Timber.e("ERROR RESP ${Gson().toJson(errorResponse.exception.localizedMessage)}")
            return StateResult.Error(errorResponse.exception)
        }
    }

}