package com.zbojas.weatherdemo.model.forecast

data class ForecastData(
        val context: List<Any>,
        val geometry: Geometry,
        val properties: Properties,
        val type: String
)