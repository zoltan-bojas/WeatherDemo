package com.zbojas.weatherdemo.model.forecast

data class Geometry(
    val coordinates: List<List<List<Double>>>,
    val type: String
)