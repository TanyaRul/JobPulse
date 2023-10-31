package ru.practicum.android.diploma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.practicum.android.diploma.databinding.FragmentSimilarBinding

class Similar : Fragment() {
    private var _binding: FragmentSimilarBinding? = null
    private val binding: FragmentSimilarBinding get() = _binding!!

    private fun setUiListeners(){
        with(binding){
            navigationBar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSimilarBinding.inflate(inflater,container,false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUiListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}