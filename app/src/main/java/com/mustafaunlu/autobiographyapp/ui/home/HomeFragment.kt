package com.mustafaunlu.autobiographyapp.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mustafaunlu.autobiographyapp.R
import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.models.Person
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
    private lateinit var personSocials: List<Social>
    private lateinit var personProjects: List<Portfolio>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        with(binding) {
            btnContact.setOnClickListener {
                navigateToOtherFragment(HomeFragmentDirections.actionHomeFragmentToContactFragment(personSocials.toTypedArray()))
            }
            btnAbout.setOnClickListener {
                navigateToOtherFragment(HomeFragmentDirections.actionHomeFragmentToAboutFragment(personAbout))
            }
            btnBlogs.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_blogsFragment)
            }
            btnPortfolio.setOnClickListener {
                navigateToOtherFragment(HomeFragmentDirections.actionHomeFragmentToPortfolioFragment(personProjects.toTypedArray()))
            }
        }
    }
    private fun navigateToOtherFragment(action: NavDirections) {
        findNavController().navigate(action)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setObserver() {
        viewModel.personData.observe(viewLifecycleOwner) {
            when (it) {
                NetworkResponse.Loading -> { }

                is NetworkResponse.Success -> {
                    initializeData(it.result)
                    binding.homePersonImage.loadImage(it.result.image)
                    binding.descriptionWebview.apply {
                        settings.loadWithOverviewMode = true
                        settings.useWideViewPort = true
                        settings.javaScriptEnabled = true
                        setBackgroundColor(0)
                        loadData(html, "text/html", "UTF-8")
                    }
                }

                is NetworkResponse.Error -> {}
            }
        }
    }
    private fun initializeData(data: Person) {
        html = data.description
        personAbout = data.about
        personSocials = data.social
        personProjects = data.portfolio
    }
}
