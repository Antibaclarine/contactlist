package dev.clarine.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.clarine.contact.databinding.ContactListBinding
import jp.wasabeef.picasso.transformations.CropCircleTransformation

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
           Picasso
               .get()
               .load(contacts.avatar)
               .resize(80,80)
               .centerCrop()
               .transform(CropCircleTransformation())
               .into(holder.binding.ivPerson)

        }

    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}




class ContactViewHolder(val binding: ContactListBinding) : RecyclerView.ViewHolder(binding.root)