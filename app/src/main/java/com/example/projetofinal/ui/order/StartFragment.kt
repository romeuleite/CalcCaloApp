package com.example.projetofinal.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetofinal.R
import com.example.projetofinal.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.goToTmbBtn.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_tmbFragment)
        }

        binding.goToListBtn.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_listFragment)
        }

        binding.goToDiaryBtn.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_diaryFragment)
        }

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}