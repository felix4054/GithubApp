package by.kavalchuk.aliaksandr.github.di

import by.kavalchuk.aliaksandr.github.data.api.ApiService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun baseUrl() = "https://api.github.com/search/"

    @Provides
    @Singleton
    internal fun provideRetrofit(
        baseUrl: String,
        gson: Gson,
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        gsonBuilder.setDateFormat("yyyy-MM-dd")
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun getRetroServiceInterface(retroFit: Retrofit): ApiService {
        return retroFit.create(ApiService::class.java)
    }


}