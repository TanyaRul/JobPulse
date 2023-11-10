package ru.practicum.android.diploma.filter.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.practicum.android.diploma.filter.domain.models.AbstractData
import ru.practicum.android.diploma.filter.presentation.util.ParentDataFragment
import ru.practicum.android.diploma.filter.presentation.view_model.FilterSharedVm
import ru.practicum.android.diploma.filter.presentation.view_model.IndustryVm
import ru.practicum.android.diploma.filter.recycler.AreaAdapter

class Industry : ParentDataFragment() {
    override val vm: IndustryVm by viewModel()
    private val viewModel: FilterSharedVm by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigationBar.title = "Индустрия"
        adapter.setAdapterType(AreaAdapter.CATEGORIES)
        adapter.setNewItemClickListener() {
            vm.dataToSendBack = it
            vm.selectItemInDataList(it)
        }
    }

    override fun exitExtraWhenSystemBackPushed() {
        // Для поиска вакансии по региону необходимо передать в поисковый запрос id региона
        vm.dataToSendBack?.let {
            viewModel.industry = AbstractData(id = it.id, name = it.name)
        }
        findNavController().popBackStack()
    }
}