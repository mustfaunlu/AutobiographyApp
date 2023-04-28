package com.mustafaunlu.autobiographyapp.ui.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mustafaunlu.autobiographyapp.data.models.Portfolio
import com.mustafaunlu.autobiographyapp.databinding.FragmentPortfolioBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PortfolioFragment : Fragment() {
    private lateinit var binding: FragmentPortfolioBinding
    private val args: PortfolioFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPortfolioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val adapter = PortfolioAdapter(args.personProjects.toList()) { portfolio ->
                clickToPortfolioDetail(portfolio)
            }
            rvPortfolio.adapter = adapter
        }
    }
    private fun clickToPortfolioDetail(portfolio: Portfolio) {
        val action = PortfolioFragmentDirections.actionPortfolioFragmentToPortfolioDetailFragment(portfolio)
        findNavController().navigate(action)
    }
}
