package dev.clarine.contact.Ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.clarine.contact.R
import dev.clarine.contact.ViewModel.ContactsViewModel
import dev.clarine.contact.databinding.ActivityContactRegisterBinding
import dev.clarine.contact.model.ContactData

class ContactRegister : AppCompatActivity() {
    lateinit var binding: ActivityContactRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            validateRegisterContacts()
        }

    }



    fun validateRegisterContacts() {
        val name = binding.ivperson.toString().trim()
        val contacts = binding.tilphoneNumber.toString().trim()
        val email = binding.tilEmail.toString().trim()

        var error = false
        if (name.isBlank()) {
            binding.tilName.error = getString(R.string.name_is_required)
            error = true
        }

        if (contacts.isBlank()) {
            binding.tilphoneNumber.error = getString(R.string.contacts_is_required)
            error = true
        }

        if (email.isBlank()) {
            binding.tilEmail.error = getString(R.string.email_is_required)
            error = true
        }

        if (!error) {
            val newContact = ContactData(contactId = 0, displayName = name, phoneNumber = contacts, email = email, avatar = "")
            val contactsViewModel = ContactsViewModel()
            contactsViewModel.saveContact(newContact)
            Toast.makeText(this, "Contact added successfully.", Toast.LENGTH_LONG).show()
            finish()
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }
    }


}



