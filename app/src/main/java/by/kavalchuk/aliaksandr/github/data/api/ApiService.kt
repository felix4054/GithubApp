package by.kavalchuk.aliaksandr.github.data.api

import by.kavalchuk.aliaksandr.github.data.network.model.GitList
import by.kavalchuk.aliaksandr.github.data.network.model.GitUsers
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("search/repositories")
    suspend fun getSearchApi(
        @Query("q") query: String
    ): Response<GitList>

    @GET("users/{username}")
    suspend fun getUserApi(
       @Path("username") user: String
    ): Response<GitUsers>
}