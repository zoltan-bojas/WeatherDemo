package com.zbojas.weatherdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherDemoApplication

fun main(args: Array<String>) {
    runApplication<WeatherDemoApplication>(*args)
}
