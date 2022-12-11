package com.raphael.shoe_inventory_udacity.fragment

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.raphael.shoe_inventory_udacity.R
import com.raphael.shoe_inventory_udacity.databinding.ListingFragmentBinding
import com.raphael.shoe_inventory_udacity.viewmodel.ShoeListViewModel
import kotlin.random.Random

class ListingFragment : Fragment(R.layout.listing_fragment) {

    lateinit var binding: ListingFragmentBinding
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.listing_fragment, container, false
        )

//        to display the fragment titled
        (activity as AppCompatActivity).supportActionBar?.show()
//        Set whether home should be displayed as an "up" affordance. Set this to true if selecting "home"
//        returns up by a single level in your UI rather than back to the top level or front page.
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        binding.lifecycleOwner = requireActivity()

//        click to go take details of shoes
        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment3())
        }

//        indicate that the this fragment would like to participate in populating the
//        options menu by receiving a call to onCreateOptionsMenu and related methods.
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]

//        subscribes to changes on details view
        viewModel.shoes.observe(viewLifecycleOwner) { shoes ->
            for (i in shoes) {

                // binds to root linearLayout
                val viewsToBeAdded = binding.shoeList

                var params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )

//              binds to text view
                val notes = TextView(context?.applicationContext)

                // gets text for each from the loop
                notes.text = i.toString()

                viewsToBeAdded.addView(notes)
            }
        }
        return binding.root
    }

    //Initialize the contents of the Fragment host's standard options menu.
    // You should place your menu items in to menu.
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // logout and navigate to the login fragment
        findNavController().navigate(ListingFragmentDirections.actionListingFragmentToLoginFragment2())
        return super.onOptionsItemSelected(item)
    }

}