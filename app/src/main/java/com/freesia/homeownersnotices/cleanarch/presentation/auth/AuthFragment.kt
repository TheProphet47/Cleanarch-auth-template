package com.freesia.homeownersnotices.cleanarch.presentation.auth

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.freesia.homeownersnotices.R
import com.freesia.homeownersnotices.core.extension.failure
import com.freesia.homeownersnotices.core.extension.observe
import com.freesia.homeownersnotices.core.platform.BaseFragment
import com.freesia.homeownersnotices.databinding.FragmentAuthBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : BaseFragment(R.layout.fragment_auth) {

    companion object {
        @JvmStatic
        fun newInstance() = AuthFragment()
    }

    private val viewModel by viewModel<AuthViewModel>()
    private lateinit var binding: FragmentAuthBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthBinding.bind(view)

        initView()
        initViewModel()
    }

    private fun initView() {
        binding.authSignIn.setOnClickListener { viewModel.login(binding.authPhone.text.toString()) }
    }

    private fun initViewModel() = with(viewModel) {
        observe(loginResult) { result ->
            when (result) {
                is UiLoginResult.True -> findNavController().navigate(R.id.action_authFragment_to_mainFragment)
                is UiLoginResult.False -> binding.authPhoneLayout.error = result.phoneMessage
            }
        }

        failure(failure) { handleFailure(it) }
    }
}