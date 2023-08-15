package dev.clarine.contact.Ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dev.clarine.contact.ViewModel.ContactsViewModel
import dev.clarine.contact.databinding.ActivityContactsDetailBinding

class ContactDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: ContactsViewModel
    private lateinit var binding: ActivityContactsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityContactsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ContactsViewModel::class.java)
        val contactId = intent.getIntExtra("CONTACT_ID", 0)
        viewModel.getContactById(contactId)
        viewModel.getContactLiveData().observe(this) { contact ->
//            if (contact != null) {
//                displayContactDetails(contact)
//            } else {
//                Toast.makeText(this, "Contact not found", Toast.LENGTH_SHORT).show()
//            }
//        }
    }
//    private fun displayContactDetails(contact: ContactData) {
//        binding.tvnamy.text = contact.displayName
//        binding.tvnos.text = contact.number
//        binding.tvmail.text = contact.email
//        if (!contact.avatar.isNullOrEmpty()) {
//            Picasso
//                .get()
//                .load(contact.avatar)
//                .resize(80, 80)
//                .centerCrop()
//                .transform(CropCircleTransformation())
//                .into(binding.ivface)
//        }
    }
}