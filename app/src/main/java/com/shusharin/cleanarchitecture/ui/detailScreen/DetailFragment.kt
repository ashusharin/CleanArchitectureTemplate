package com.shusharin.cleanarchitecture.ui.detailScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shusharin.cleanarchitecture.R
import com.shusharin.cleanarchitecture.data.di.App
import com.shusharin.cleanarchitecture.ui.mainScreen.MainScreenViewModel
import com.shusharin.cleanarchitecture.utils.ViewModelFactory
import javax.inject.Inject

class DetailFragment : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]
    }
    private val appComponent by lazy {
        (activity?.application as App).appComponent
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
        println("")
    }

}