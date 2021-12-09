package com.shusharin.cleanarchitecture.ui.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.shusharin.cleanarchitecture.data.di.App
import com.shusharin.cleanarchitecture.databinding.FragmentMainScreenBinding
import com.shusharin.cleanarchitecture.ui.mainScreen.pager.PagerAdapter
import com.shusharin.cleanarchitecture.ui.mainScreen.recyclerView.Adapter
import com.shusharin.cleanarchitecture.ui.mainScreen.recyclerView.category.CategoryAdapter
import com.shusharin.cleanarchitecture.utils.ViewModelFactory
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MainScreenFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainScreenViewModel::class.java]
    }
    private val appComponent by lazy {
        (activity?.application as App).appComponent
    }
    private lateinit var adapterProduct: Adapter
    private lateinit var adapterProductMegaSale: Adapter
    private lateinit var adapterProductStock: Adapter
    private lateinit var adapterCategory: CategoryAdapter

    private lateinit var pagerAdapter: PagerAdapter


    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listProduct.onEach {
                    adapterProduct.productList = it.take(10)
                    adapterProductStock.productList = it.drop(10)
                    adapterProductMegaSale.productList = it.takeLast(8)
                }.launchIn(this)
            }
        }

        return root

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // TODO: 07.12.2021 реализовать сохранение списка продуктов
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        adapterProduct = Adapter()
        binding.rvProductList.adapter = adapterProduct

        adapterProductStock = Adapter()
        binding.rvProductListStock.adapter = adapterProductStock

        adapterProductMegaSale = Adapter()
        binding.rvProductListMegasale.adapter = adapterProductMegaSale

        adapterCategory = CategoryAdapter()
        binding.rvCategoryList.adapter = adapterCategory

        pagerAdapter = PagerAdapter()
        binding.pagerOffer.adapter = pagerAdapter
    }
}