package com.example.projetofinal.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.projetofinal.R
import com.example.projetofinal.databinding.FragmentTmbBinding
import com.example.projetofinal.model.FoodViewModel
import java.math.RoundingMode


class TmbFragment : Fragment() {

    private var _binding: FragmentTmbBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: FoodViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTmbBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            tmbFragment = this@TmbFragment
        }
    }

    fun calculateTMB() {
        val weight = binding.editTextWeight.text.toString().toDoubleOrNull()
        val height = binding.editTextHeight.text.toString().toDoubleOrNull()
        val age = binding.editTextAge.text.toString().toDoubleOrNull()
        val gender = when (binding.genderOptions.checkedRadioButtonId) {
            R.id.female_btn -> 2
            else -> 1
        }

        val tmb = if (gender == 1) {
            (66.5 + (13.75 * weight!!) + (5 * height!!) - (6.8 * age!!))
        } else {
            (665.1 + (9.56 * weight!!) + (1.8 * height!!) - (4.7 * age!!))
        }

        sharedViewModel.setTmb(tmb)

        displayTMB(tmb)

    }

    private fun displayTMB(tmb: Double) {
        val formattedTMB = tmb.toBigDecimal().setScale(1, RoundingMode.UP).toString()
        binding.tmbEditText.text = getString(R.string.tmb_result, formattedTMB)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}