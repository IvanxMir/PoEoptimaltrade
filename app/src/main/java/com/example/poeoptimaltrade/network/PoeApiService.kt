package com.example.poeoptimaltrade.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Адрес данных сайта
private const val BASE_URL = "https://poe.ninja/api/data/"

// Переменные для работы и настройки Retrofit и Moshi
private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

// Запросы к сайту
interface PoeApiService {
    @GET("CurrencyOverview")
    fun getData(
        @Query("league") LEAGUE: String,
        @Query("type") category: String
    ): Deferred<PoeOrdinaryResponseData>

    @GET("ItemOverview")
    fun getRestData(
        @Query("league") LEAGUE: String,
        @Query("type") category: String
    ): Deferred<PoeRestResponseData>
}

// Создание интерфейса Retrofit
object PoeApi{
    val retrofitService: PoeApiService by lazy{
        retrofit.create(PoeApiService::class.java)
    }
}

