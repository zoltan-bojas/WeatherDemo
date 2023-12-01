package com.zbojas.weatherdemo.controller

import com.zbojas.weatherdemo.service.ForecastService
import com.zbojas.weatherdemo.model.forecastResponse.ForecastResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class WeatherController(private val forecastService : ForecastService) {

    @GetMapping("/forecast")
    fun getForecast(): Mono<ForecastResponse> = forecastService.getForecast()
}