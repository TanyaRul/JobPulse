package ru.practicum.android.diploma.filter.presentation.sharedviewmodel

import androidx.lifecycle.ViewModel
import ru.practicum.android.diploma.filter.domain.models.AbstractData
import ru.practicum.android.diploma.filter.domain.models.FilterData

class FilterSharedVm : ViewModel() {
    private var filters: FilterData? = null

    fun setFilter(remoteFilter: FilterData) {
        filters = remoteFilter
    }

    fun deleteFilters() {
        filters = null
    }

    fun setIndustry(industry: AbstractData) {
        filters?.let {
            filters = it.copy(idIndustry = industry.id.toString(), nameIndustry = industry.name)
        }
    }

    fun getFilters() = this.filters


}