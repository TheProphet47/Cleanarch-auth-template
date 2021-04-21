package com.freesia.homeownersnotices.cleanarch.presentation.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.freesia.homeownersnotices.R
import com.freesia.homeownersnotices.core.extension.failure
import com.freesia.homeownersnotices.core.extension.observe
import com.freesia.homeownersnotices.core.platform.BaseFragment
import com.freesia.homeownersnotices.core.platform.CommonRecyclerAdapter
import com.freesia.homeownersnotices.databinding.FragmentMainBinding
import com.freesia.homeownersnotices.databinding.ItemMainMessageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment(R.layout.fragment_main) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var binding: FragmentMainBinding

    private lateinit var messagesAdapter: CommonRecyclerAdapter<UiMessageData>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        initView()
        initViewModel()

        viewModel.requestMessages()
    }

    private fun initView() {
        messagesAdapter = CommonRecyclerAdapter(R.layout.item_main_message) { itemView, data  ->
            val binding = ItemMainMessageBinding.bind(itemView)
            binding.mainTextMessage.text = data.text
            binding.mainDate.text = data.date
        }

        binding.mainMessages.adapter = messagesAdapter
        binding.mainMessages.layoutManager = LinearLayoutManager(context)

        messagesAdapter.listData = listOf(
            UiMessageData("Message 1", "20.04.2021"),
            UiMessageData("Message 2", "20.04.2021")
        )
    }

    private fun initViewModel() = with(viewModel) {
        observe(messages) { messages ->
            messagesAdapter.listData = messages.orEmpty()
        }

        failure(failure) { handleFailure(it) }
    }

}