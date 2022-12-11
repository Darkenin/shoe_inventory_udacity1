package com.raphael.shoe_inventory_udacity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.raphael.shoe_inventory_udacity.R

import com.raphael.shoe_inventory_udacity.databinding.OverviewFragmentBinding

class OverviewFragment : Fragment(R.layout.overview_fragment) {

    lateinit var binding: OverviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.overview_fragment, container, false
        )
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Overview"

        binding.lifecycleOwner = requireActivity()

        binding.button.setOnClickListener {
            findNavController().navigate(
                OverviewFragmentDirections.actionOverviewFragment2ToListingFragment(
                    "",
                    "",
                    ""
                )
            )
        }
        return binding.root
    }
}