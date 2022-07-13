package com.example.poeoptimaltrade.network

import com.squareup.moshi.Json

// Классы для работы Moshi
// Data классы для категорий Currency и Fragment
data class PoeOrdinaryResponseData(
    @Json(name = "lines") val lines: List<PoeOrdinaryData>
)

data class PoeOrdinaryData(
    @Json(name = "chaosEquivalent") val price: Float,
    @Json(name = "currencyTypeName") val name: String
)

// Data классы для всех остальных категорий
data class PoeRestResponseData(
    @Json(name = "lines") val lines: List<PoeRestData>
)

data class PoeRestData(
    @Json(name = "chaosValue") val price: Float,
    @Json(name = "name") val name: String,
    @Json(name = "icon") val icon: String,
)

/*data class PoeStandardOrdinaryResponseData(
    @Json(name = "lines") val lines: List<PoeStandardOrdinaryData>
)

data class PoeStandardOrdinaryData(
    @Json(name = "chaosEquivalent") val price: Float,
    @Json(name = "currencyTypeName") val name: String
)*/