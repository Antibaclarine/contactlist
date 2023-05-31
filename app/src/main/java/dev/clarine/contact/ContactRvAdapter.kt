package dev.clarine.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.clarine.contact.databinding.ContactListBinding

class ContactRvAdapter(val contactsList:List<ContactData>):RecyclerView.Adapter<ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding=ContactListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contacts=contactsList[position]
        holder.binding.apply{
            tvName.text=contacts.displayName
            tvEmail.text=contacts.email
            tvPhoneNo.text=contacts.phoneNumber

        }

    }



    override fun getItemCount(): Int {
        return contactsList.size
    }
}




class ContactViewHolder(val binding: ContactListBinding) : RecyclerView.ViewHolder(binding.root)