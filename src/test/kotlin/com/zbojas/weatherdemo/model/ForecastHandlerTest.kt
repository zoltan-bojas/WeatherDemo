package com.zbojas.weatherdemo.model

import com.zbojas.weatherdemo.view.forecastResponse.ForecastResponse
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.io.File

@SpringBootTest
class ForecastHandlerTest {



    @Test
    fun testMapStringToForecastResponse() {
        val forecastJSONString1 : String = javaClass.getResource("/test1_forecast").readText() //File("/test1_forecast").readText()
        val response = mockk<WebClient.ResponseSpec>()
        val spec = mockk<WebClient.RequestHeadersUriSpec<*>>()
        val client = mockk<WebClient>()

        every { response.bodyToMono(String::class.java) } returns Mono.just(forecastJSONString1)
        every { spec.uri("/gridpoints/MLB/33,70/forecast")} returns spec
        every { spec.retrieve() } returns response
        every { client.get() } returns spec
        val resp : ForecastResponse? = ForecastHandler(client).getForecast().block()
        assert(resp!!.daily[0].forecast_blurp == "Chance of Rain")
        assert(resp.daily[0].temp_high_celsius == 5.0)
        assert(resp.daily[0].day_name == "WEDNESDAY")
    }

    @Test
    fun testMapStringToForecastResponse2() {
        val forecastJSONString1 : String = javaClass.getResource("/test2_forecast").readText() //File("/test1_forecast").readText()
        val response = mockk<WebClient.ResponseSpec>()
        val spec = mockk<WebClient.RequestHeadersUriSpec<*>>()
        val client = mockk<WebClient>()

        every { response.bodyToMono(String::class.java) } returns Mono.just(forecastJSONString1)
        every { spec.uri("/gridpoints/MLB/33,70/forecast")} returns spec
        every { spec.retrieve() } returns response
        every { client.get() } returns spec
        val resp : ForecastResponse? = ForecastHandler(client).getForecast().block()
        assert(resp!!.daily[0].forecast_blurp == "Sunny for a Monday")
        assert(resp.daily[0].temp_high_celsius == 10.0)
        assert(resp.daily[0].day_name == "MONDAY")
    }


}