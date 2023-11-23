package com.zbojas.weatherdemo.view.forecastResponse

data class Daily(
    val day_name: String,
    val temp_high_celsius: Double,
    val forecast_blurp: String
)