package com.mustafaunlu.autobiographyapp.ui.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafaunlu.autobiographyapp.data.models.Portfolio
import com.mustafaunlu.autobiographyapp.databinding.PortfolioItemBinding
import com.mustafaunlu.autobiographyapp.utility.loadImage

class PortfolioAdapter(private val projectList: List<Portfolio>, private val onItemClicked: (Portfolio) -> Unit) : RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val view = PortfolioItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PortfolioViewHolder(view)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        val portfolio = projectList[position]
        holder.bind(portfolio)
    }

    override fun getItemCount(): Int {
        return projectList.size
    }

    inner class PortfolioViewHolder(private val binding: PortfolioItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(portfolio: Portfolio) {
            binding.apply {
                portfolioImg.loadImage(portfolio.image)
                portfolioTitle.text = portfolio.title
                portfolioDescription.text = portfolio.description
                root.setOnClickListener {
                    onItemClicked(portfolio)
                }
            }
        }
    }
}
