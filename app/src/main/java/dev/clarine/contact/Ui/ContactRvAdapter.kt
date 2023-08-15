package dev.clarine.contact.Ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.clarine.contact.databinding.ContactListBinding
import dev.clarine.contact.model.ContactData
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactRvAdapter(val contactsList: List<ContactData>, val context: Context) :
    RecyclerView.Adapter<ContactViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contacts = contactsList[position]

        holder.binding.apply {
            tvEmail.text = contacts.email
            tvName.text = contacts.displayName
            tvPhoneNo.text = contacts.phoneNumber



            if (contacts.avatar.isNotBlank()) {
                Picasso
                    .get()
                    .load(contacts.avatar)
                    .resize(80, 80)
                    .centerCrop()
                    .transform(CropCircleTransformation())
                    .into(holder.binding.ivPerson)

            }


            cvContact.setOnClickListener {
                val intent = Intent(context, ContactDetailActivity::class.java)
                intent.putExtra("CONTACT_ID", contacts.contactId)
                context.startActivity(intent)
            }
        }
    }
    override fun getItemCount(): Int {
        return contactsList.size
    }

}



class ContactViewHolder(val binding: ContactListBinding) : RecyclerView.ViewHolder(binding.root) {}