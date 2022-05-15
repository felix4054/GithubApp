package by.kavalchuk.aliaksandr.github.data.api

import by.kavalchuk.aliaksandr.github.data.network.model.GitList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("repositories")
    suspend fun getDataFromApiAsync(
        @Query("q") query: String
    ): Response<GitList>
}