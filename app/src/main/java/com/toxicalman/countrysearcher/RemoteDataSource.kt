package com.toxicalman.countrysearcher

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RestCountries {
    @GET("/name/{name}")
    suspend fun getCountryByName(@Path("name") cityName: String): List<Country>
}

var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://countriesinfo21.herokuapp.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var restCountries: RestCountries = retrofit.create(RestCountries::class.java)
