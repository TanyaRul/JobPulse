package ru.practicum.android.diploma.filter.domain.models

data class Country(
    val name: String,
    val id: Int,
    val areas: List<Area>
)
