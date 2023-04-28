package com.mustafaunlu.autobiographyapp.ui.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mustafaunlu.autobiographyapp.databinding.FragmentPortfolioDetailBinding
import com.mustafaunlu.autobiographyapp.utility.loadImage

class PortfolioDetailFragment : Fragment() {
    private lateinit var binding: FragmentPortfolioDetailBinding
    private val args: PortfolioDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPortfolioDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            portfolioImg.loadImage(args.portfolio.image)
            portfolioTitle.text = args.portfolio.title
            portfolioDescription.text = args.portfolio.description
            portfolioLink.text = args.portfolio.link
        }
    }
}
