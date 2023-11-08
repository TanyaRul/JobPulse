package ru.practicum.android.diploma.filter.data.repository

import ru.practicum.android.diploma.filter.data.mappers.FilterConverter
import ru.practicum.android.diploma.filter.domain.interfaces.FiltersRepository
import ru.practicum.android.diploma.filter.domain.models.FilterData
import ru.practicum.android.diploma.sharedPref.FiltersStorage

class FiltersRepositoryImpl(private val sharedPrefsClient: FiltersStorage) : FiltersRepository {
    override fun getFiltersSet(): FilterData? {
        val filtersSettings = sharedPrefsClient.getParamsFilters()
        return if (filtersSettings == null) null
        else FilterConverter().convertFromDto(filtersSettings)
    }

    override fun saveFiltersSet(settingsToSave: FilterData) {
        sharedPrefsClient.addParamsFilters(FilterConverter().convertToDto(settingsToSave))
    }
}