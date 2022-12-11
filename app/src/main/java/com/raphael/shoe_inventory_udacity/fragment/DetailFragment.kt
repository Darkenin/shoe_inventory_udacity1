package com.raphael.shoe_inventory_udacity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.raphael.shoe_inventory_udacity.R
import com.raphael.shoe_inventory_udacity.databinding.DetailFragmentBinding
import com.raphael.shoe_inventory_udacity.viewmodel.ShoeListViewModel

class DetailFragment : Fragment(R.layout.detail_fragment) {
    lateinit var binding: DetailFragmentBinding
    lateinit var viewModel: ShoeListViewModel

    lateinit var shoeName: String
    lateinit var shoeManufacturer: String
    var shoeDes: String = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.detail_fragment, container, false
        )

        //        to display the fragment titled
        (activity as AppCompatActivity).supportActionBar?.show()
        // viewmodel provider
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.lifecycleOwner = requireActivity()
        // viewmodel from laypot
        binding.viewmodel = viewModel

        // initialise the strings objected
        shoeName = binding.nameText.text.toString()
        shoeManufacturer = binding.manufacturerText.text.toString()

        // register to changes on shoe name data
        viewModel.shoeName.observe(viewLifecycleOwner) { name ->
            if (name != null) shoeName = name
        }
//      // register to changes on shoe company data
        viewModel.shoeCompany.observe(viewLifecycleOwner) { company ->
            if (company != null) shoeManufacturer = company
        }
        // register to changes on shoe description data
        viewModel.shoeDescription.observe(viewLifecycleOwner) { des ->
            if (des != null) shoeDes = des
        }

        // listens to clicks on the save button
        binding.save.setOnClickListener {
            viewModel.addShoeDetails(mutableListOf(shoeName, shoeManufacturer, shoeDes))
            findNavController().navigate(
                DetailFragmentDirections.actionDetailFragment3ToListingFragment(
                    shoeName,
                    shoeManufacturer,
                    shoeDes
                )
            )
            viewModel.navigationComplete()
        }

        // listens to clicks on the cancel button
        binding.cancel.setOnClickListener {
            findNavController().navigate(
                DetailFragmentDirections.actionDetailFragment3ToListingFragment(
                    "",
                    "",
                    ""
                )
            )
        }
        return binding.root
    }
}