package com.zbojas.weatherdemo.model.forecast

data class Properties(
        val elevation: Elevation,
        val forecastGenerator: String,
        val generatedAt: String,
        val periods: List<Period>,
        val units: String,
        val updateTime: String,
        val updated: String,
        val validTimes: String
)