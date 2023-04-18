package com.mustafaunlu.autobiographyapp.ui.blogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mustafaunlu.autobiographyapp.databinding.FragmentBlogsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlogsFragment : Fragment() {

    private lateinit var viewModel: BlogsViewModel
    private val _binding: FragmentBlogsBinding? = null
    private var binding = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlogsBinding.inflate(inflater, container, false)
        return binding.root
    }



}