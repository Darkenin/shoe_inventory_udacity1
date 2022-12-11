package com.raphael.shoe_inventory_udacity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.raphael.shoe_inventory_udacity.R
import com.raphael.shoe_inventory_udacity.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment(R.layout.instructions_fragment) {
    lateinit var binding: InstructionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.instructions_fragment, container, false
        )

        binding.lifecycleOwner = requireActivity()

        binding.nextNav.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragment2ToOverviewFragment23())
        }

        return binding.root
    }


}