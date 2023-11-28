package com.zbojas.weatherdemo.controller

import com.zbojas.weatherdemo.model.ForecastHandler
import com.zbojas.weatherdemo.view.forecastResponse.ForecastResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class WeatherController(private val handler : ForecastHandler) {

    @GetMapping("/forecast")
    fun getForecast(): Mono<ForecastResponse> = handler.getForecast()
}