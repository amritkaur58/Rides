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
import com.amrit.rides.viewmodels.AppViewModel

abstract class BaseFragment<DataBinding : ViewDataBinding, viewModel : ViewModel> : Fragment() {

    private lateinit var dataBinding: DataBinding
    private lateinit var viewModel: ViewModel
    abstract fun getLayoutId(): Int


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        viewModel = ViewModelProvider(requireActivity(), factory)[getViewModel()]
        return dataBinding.root
    }

    public abstract fun getViewModel(): Class<AppViewModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.apply {
            var lifecycleOwner = this@BaseFragment
        }
    }

    fun getDataBinding() = dataBinding

}