package com.example.screenflow_validation_using_variables

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.screenflow_validation_using_variables.databinding.FragmentNameInfoBinding

class NameInfoFragment: Fragment() {

    private var _binding: FragmentNameInfoBinding? = null
    private val binding: FragmentNameInfoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNameInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            // Data in fragment manager is arguments instead of intent.
            firstNameTv.text = arguments?.getString("First") ?: "First"
            lastNameTv.text = arguments?.getString("Last") ?: "Last"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}