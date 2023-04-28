package com.mustafaunlu.autobiographyapp.ui.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafaunlu.autobiographyapp.data.models.Social
import com.mustafaunlu.autobiographyapp.databinding.ContactItemBinding
import com.mustafaunlu.autobiographyapp.utility.loadImage

class ContactAdapter(private val contactList: List<Social>) : RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contactList[position])
    }
}

class ContactViewHolder(private val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(contact: Social) {
        binding.apply {
            contactImage.loadImage(contact.image)
            contactTitle.text = contact.title
            contactLinkButton.text = contact.link
        }
    }
}
