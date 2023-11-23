package com.zbojas.weatherdemo.controller

import com.zbojas.weatherdemo.model.ForecastHandler
import com.zbojas.weatherdemo.view.forecastResponse.ForecastResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@RestController
class WeatherController(private val client : WebClient = org.springframework.web.reactive.function.client.WebClient.create("https://api.weather.gov")) {
    @GetMapping("/forecast")
    fun getForecast(): Mono<ForecastResponse> = ForecastHandler(client).getForecast();
}