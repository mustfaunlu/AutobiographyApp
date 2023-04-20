package com.mustafaunlu.autobiographyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mustafaunlu.autobiographyapp.R
import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.models.Portfolio
import com.mustafaunlu.autobiographyapp.data.models.Social
import com.mustafaunlu.autobiographyapp.databinding.FragmentHomeBinding
import com.mustafaunlu.autobiographyapp.utility.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var html: String
    private lateinit var personAbout: String
    private lateinit var personSocials: Array<Social>
    private lateinit var personProjects: Array<Portfolio>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setObserver()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContact.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToContactFragment(personSocials)
            findNavController().navigate(action)
        }
        binding.btnAbout.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAboutFragment(personAbout)
            findNavController().navigate(action)
        }
        binding.btnBlogs.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_blogsFragment)
        }
        binding.btnPortfolio.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToPortfolioFragment(personProjects)
            findNavController().navigate(action)
        }
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
                    personAbout = it.result.about
                    personSocials = it.result.social
                    personProjects = it.result.portfolio
                }
                NetworkResponse.Loading -> {}
                is NetworkResponse.Error -> {}
            }
        }
    }
}
