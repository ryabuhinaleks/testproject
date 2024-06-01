package com.example.projecttest.presentation.screen.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.projecttest.R
import com.example.projecttest.databinding.FragmentEstateDetailBinding
import com.example.projecttest.presentation.root.navigation.withArguments

class EstateDetailFragment : Fragment() {

    private val estateId: Int by lazy { arguments?.getInt(ID) ?: 0 }

    private val binding by lazy {
        FragmentEstateDetailBinding.bind(requireView())
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[EstateDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_estate_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() = with(binding) {
        viewModel.estateObject.observe(viewLifecycleOwner) { item ->
            price.text = item.price
            name.text = item.name
        }
        viewModel.getEstateObjectById(estateId)
    }

    companion object {
        private const val ID = "ID"

        fun newInstance(id: Int) = EstateDetailFragment().withArguments {
            putInt(ID, id)
        }
    }
}