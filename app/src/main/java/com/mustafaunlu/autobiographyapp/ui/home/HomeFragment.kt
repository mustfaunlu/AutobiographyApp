package com.mustafaunlu.autobiographyapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.databinding.FragmentHomeBinding
import com.mustafaunlu.autobiographyapp.utility.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var html: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setObserver()
        return binding.root
    }

    private fun setObserver() {
        viewModel.personData.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResponse.Success -> {
                    binding.homePersonImage.loadImage(it.result.image)
                    html = it.result.description
                    binding.descriptionWebview.apply {
                        settings.loadWithOverviewMode = true
                        settings.useWideViewPort = true
                        loadData(html, "text/html", "UTF-8")
                    }
                    Log.i("HomeFragment", "onCreateView: $html")
                }

                is NetworkResponse.Error -> {}
                is NetworkResponse.Loading -> {}
            }
        }
    }
}
