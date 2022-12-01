package com.example.projetofinal.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetofinal.ButtonClickListener
import com.example.projetofinal.R
import com.example.projetofinal.adapter.FoodCardAdapter
import com.example.projetofinal.databinding.FragmentListBinding
import com.example.projetofinal.model.FoodViewModel


class ListFragment : Fragment(), ButtonClickListener {

    private var _binding: FragmentListBinding? = null

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
        _binding = FragmentListBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            listFragment = this@ListFragment

        }


        binding.verticalRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.verticalRecyclerView.adapter = FoodCardAdapter(activity,this)


    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_listFragment_to_diaryFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onButtonClickListener(number: Double) {
        sharedViewModel.setClickedRadioButton(number)
    }
}