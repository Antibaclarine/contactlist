package dev.clarine.contact.Ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dev.clarine.contact.ViewModel.ContactsViewModel
import dev.clarine.contact.databinding.ActivityMainBinding
import dev.clarine.contact.model.ContactData


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val  contactsViewModel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.faAdd.setOnClickListener {
            val intent = Intent(this, ContactRegister::class.java)
            startActivity(intent)
        }

    }


    override fun onResume() {
        super.onResume()
        contactsViewModel.getContacts().observe(this, Observer { contacts->displayContact(contacts) })
        binding.faAdd.setOnClickListener {
          startActivity(Intent(this,ContactRegister::class.java))
        }

    }


    fun displayContact(contactList: List<ContactData>){

        var contactAdapter= ContactRvAdapter(contactList, this)
        binding.rvContact.layoutManager=LinearLayoutManager(this)
        binding.rvContact.adapter=contactAdapter
    }


}