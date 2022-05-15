package by.kavalchuk.aliaksandr.github.data.network.repository

import by.kavalchuk.aliaksandr.github.data.api.ApiRepository
import by.kavalchuk.aliaksandr.github.data.api.ApiService
import by.kavalchuk.aliaksandr.github.data.network.model.GitList
import by.kavalchuk.aliaksandr.github.data.network.model.GitUsers
import by.kavalchuk.aliaksandr.github.utils.StateResult
import javax.inject.Inject

class GitRepository @Inject constructor(private val apiService: ApiService) : ApiRepository {

    override suspend fun makeApiSearchResponse(query: String): StateResult<GitList> {
        return try {
            val dataResponse = apiService.getSearchApi(query)
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
            StateResult.Success(newsResponse!!)

        } catch (exception: Exception) {

            val errorResponse = StateResult.Error(exception)
//            Timber.e("ERROR RESP ${Gson().toJson(errorResponse.exception.localizedMessage)}")
            StateResult.Error(errorResponse.exception)
        }
    }

    override suspend fun makeApiUserResponse(user: String): StateResult<GitUsers> {
        return try {
            val dataResponse = apiService.getUserApi(user)
            var newsResponse: GitUsers? = null
            when {
                dataResponse.isSuccessful -> {
//                    Timber.e("SUCCESS RESP ${Gson().toJson(dataResponse.body())}")
                    newsResponse = dataResponse.body()
                }
                else -> {
//                    Timber.e("ERROR RESP ${Gson().toJson(dataResponse.errorBody())}")
                }
            }
            StateResult.Success(newsResponse!!)

        } catch (exception: Exception) {

            val errorResponse = StateResult.Error(exception)
//            Timber.e("ERROR RESP ${Gson().toJson(errorResponse.exception.localizedMessage)}")
            StateResult.Error(errorResponse.exception)
        }
    }

}