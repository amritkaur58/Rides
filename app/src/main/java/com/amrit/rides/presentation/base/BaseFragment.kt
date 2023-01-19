package com.amrit.rides.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.amrit.rides.viewmodels.AppViewModel

abstract class BaseFragment<DataBinding : ViewDataBinding, viewModel : ViewModel> : Fragment() {

    private lateinit var dataBinding: DataBinding
    protected lateinit var viewModel: viewModel
    abstract fun getLayoutId(): Int
    lateinit var navController : NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        viewModel = ViewModelProvider(requireActivity(), factory as ViewModelProvider.Factory).get(getViewModel())
        return dataBinding.root
    }

    public abstract fun getViewModel(): Class<viewModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.apply {
            var lifecycleOwner = this@BaseFragment
        }
        navController =Navigation.findNavController(view)
    }

    fun getDataBinding() = dataBinding

}