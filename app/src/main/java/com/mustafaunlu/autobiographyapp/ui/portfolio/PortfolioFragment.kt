package com.mustafaunlu.autobiographyapp.ui.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mustafaunlu.autobiographyapp.R

class PortfolioFragment : Fragment() {

    private lateinit var viewModel: PortfolioViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }
}
