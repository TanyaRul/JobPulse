package ru.practicum.android.diploma.filter.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.practicum.android.diploma.filter.data.dto.models.Category
import ru.practicum.android.diploma.filter.domain.models.AbstarctData
import ru.practicum.android.diploma.filter.domain.models.AreaData
import ru.practicum.android.diploma.filter.presentation.util.ScreenState

open class DefaultViewModel : ViewModel() {
    val _errorMsg = MutableLiveData<String>()
    val errorMsg = _errorMsg as LiveData<String>

    val _screenState =
        MutableStateFlow<ScreenState>(ScreenState.Loading(null))
    val screenState = _screenState as StateFlow<ScreenState>

    var dataToSendBack: AbstarctData? = null

    fun areaToAbstract(area: AreaData) = AbstarctData(area.id, area.name)

    fun professionToAbstract(category: Category) = AbstarctData(category.id,category.name)

}