package com.example.projecttest.presentation.screen.estatelist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projecttest.AppApplication
import com.example.projecttest.databinding.FragmentEstateListBinding
import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.presentation.root.navigation.FragmentRouter
import com.example.projecttest.presentation.screen.add.EstateAddFragment
import com.example.projecttest.presentation.screen.detail.EstateDetailFragment
import com.example.projecttest.presentation.screen.estatelist.adapter.EstateListAdapter
import javax.inject.Inject

class EstateListFragment : Fragment(), EstateListAdapter.EstateListener {

    private var router: FragmentRouter? = null

    private lateinit var binding: FragmentEstateListBinding
    private lateinit var listAdapter: EstateListAdapter

    @Inject
    lateinit var factory: EstateListViewModel.Factory

    private val viewModel by viewModels<EstateListViewModel> { factory }


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
    ): View {
        binding = FragmentEstateListBinding.inflate(inflater, container, false)
        listAdapter = EstateListAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initData()
        initListener()
    }

    private fun initRecyclerView() = with(binding.list) {
        layoutManager = LinearLayoutManager(context)
        adapter = listAdapter
    }

    private fun initData() {
        viewModel.estateObjectList.observe(viewLifecycleOwner) { items ->
            listAdapter.submitList(items)
        }
    }

    private fun initListener() = with(binding) {
        actionButton.setOnClickListener {
            router?.forward(EstateAddFragment.newInstance())
        }
    }

    override fun deleteObject(estateObject: EstateObject) {
        viewModel.deleteEstateObject(estateObject)
    }

    override fun clickObject(id: Int) {
        router?.forward(EstateDetailFragment.newInstance(id))
    }

    companion object {

        fun newInstance() = EstateListFragment()
    }
}
