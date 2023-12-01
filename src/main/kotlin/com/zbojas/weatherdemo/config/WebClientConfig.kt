package com.zbojas.weatherdemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {
    @Bean
    fun govWeatherWebClient() : WebClient = WebClient.create("https://api.weather.gov")

}