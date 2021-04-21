package com.freesia.homeownersnotices.cleanarch.presentation.root

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.freesia.homeownersnotices.R
import com.freesia.homeownersnotices.core.extension.observe
import com.freesia.homeownersnotices.core.platform.BaseFragment
import com.freesia.homeownersnotices.databinding.FragmentStartBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartFragment : BaseFragment(R.layout.fragment_start) {

    companion object {
        @JvmStatic
        fun newInstance() = StartFragment()
    }

    private val viewModel by viewModel<StartViewModel>()
    private lateinit var binding: FragmentStartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStartBinding.bind(view)

        binding.startClick.setOnClickListener { findNavController().navigate(R.id.action_startFragment_to_mainFragment) }

        observe(viewModel.isUserLoggedIn) {
            if (it == true) findNavController().navigate(R.id.action_startFragment_to_mainFragment)
            else findNavController().navigate(R.id.action_startFragment_to_authFragment)
        }
    }
}