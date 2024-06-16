package com.example.projecttest.presentation.screen.add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.projecttest.AppApplication
import com.example.projecttest.R
import com.example.projecttest.databinding.FragmentEstateAddBinding
import com.example.projecttest.presentation.root.navigation.FragmentRouter
import javax.inject.Inject

class EstateAddFragment : Fragment() {

    private var router: FragmentRouter? = null

    private val binding by lazy {
        FragmentEstateAddBinding.bind(requireView())
    }

    @Inject
    lateinit var factory: EstateAddViewModel.Factory

    private val viewModel by viewModels<EstateAddViewModel> { factory }

    private val component by lazy {
        (requireActivity().application as AppApplication).component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)

        if (context is FragmentRouter) {
            router = context
        } else {
            throw RuntimeException()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_estate_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() = with(binding) {
        button.setOnClickListener {
            viewModel.addEstateObject(price.text.toString(), address.text.toString())
        }

        viewModel.closeScreen.observe(viewLifecycleOwner) { isClose ->
            if (isClose == true) router?.close()
        }
    }


    companion object {
        fun newInstance() = EstateAddFragment()
    }
}