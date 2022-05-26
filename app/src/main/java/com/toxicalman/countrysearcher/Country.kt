package com.toxicalman.countrysearcher


data class Country(
    val name: String,
    val capital: String,
    val population: Long,
    val languages: List<Language>,
    val flag: String,
    val region: String
)
data class Language(
    val name: String
)