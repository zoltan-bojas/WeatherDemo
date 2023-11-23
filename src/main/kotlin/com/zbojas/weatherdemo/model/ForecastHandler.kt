package com.zbojas.weatherdemo.model

import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import com.google.gson.Gson
import com.zbojas.weatherdemo.view.forecastResponse.Daily
import com.zbojas.weatherdemo.model.forecast.ForecastData
import com.zbojas.weatherdemo.view.forecastResponse.ForecastResponse
import java.time.LocalDateTime


class ForecastHandler(private val client : WebClient) {

        fun getForecast(): Mono<ForecastResponse> {
            return client.get().uri("/gridpoints/MLB/33,70/forecast").retrieve().bodyToMono(String::class.java).map{res->mapStringToForecastResponse(res)}
        }

        private fun mapStringToForecastResponse(string:String): ForecastResponse {
            val forecastData = Gson().fromJson(string, ForecastData::class.java)
            return ForecastResponse(listOf<Daily>(Daily(
                    day_name = LocalDateTime.parse(forecastData.properties.periods[0].startTime.substring(0,19)).dayOfWeek.toString(),  //TODO: this might be incorrect. Not clear if "current day" supposed to be the current day at target coordinates or not
                    temp_high_celsius =(forecastData.properties.periods[0].temperature.toDouble()-32)*5/9,              //TODO: this might be incorrect. Not clear if it's only supposed to be 1 decimal place, also not clear what temp_high_celsius is, as sometimes there are multiple entries for current day, also assumes that temperatureUnit is F
                    forecast_blurp = forecastData.properties.periods[0].shortForecast)
            ))
        }


}