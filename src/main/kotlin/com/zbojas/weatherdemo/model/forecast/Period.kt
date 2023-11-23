package com.zbojas.weatherdemo.model.forecast

data class Period(
        val detailedForecast: String,
        val dewpoint: Dewpoint,
        val endTime: String,
        val icon: String,
        val isDaytime: Boolean,
        val name: String,
        val number: Int,
        val probabilityOfPrecipitation: ProbabilityOfPrecipitation,
        val relativeHumidity: RelativeHumidity,
        val shortForecast: String,
        val startTime: String,
        val temperature: Int,
        val temperatureTrend: String,
        val temperatureUnit: String,
        val windDirection: String,
        val windSpeed: String
)