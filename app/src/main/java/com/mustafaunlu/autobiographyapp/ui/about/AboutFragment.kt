package com.mustafaunlu.autobiographyapp.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mustafaunlu.autobiographyapp.databinding.FragmentAboutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : Fragment() {

    private lateinit var viewModel: AboutViewModel
    lateinit var binding: FragmentAboutBinding
    private val args: AboutFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        binding.apply {
            aboutTitleTxt.text = "about me"
            aboutDescriptionTxt.text = args.personAbout
        }
        return binding.root
    }
}
