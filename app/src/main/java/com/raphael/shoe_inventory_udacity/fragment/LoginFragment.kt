package com.raphael.shoe_inventory_udacity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.raphael.shoe_inventory_udacity.R
import com.raphael.shoe_inventory_udacity.databinding.LoginPageBinding

class LoginFragment : Fragment(R.layout.login_page) {

    lateinit var binding: LoginPageBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_page, container, false
        )

        binding.lifecycleOwner = requireActivity()

        binding.signup.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragment2ToInstructionsFragment2())
        }

        binding.signin.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragment2ToInstructionsFragment2())
        }

        return binding.root
    }
}