package dev.clarine.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import dev.clarine.contact.databinding.ActivityContactRegisterBinding

class ContactRegister : AppCompatActivity() {
    lateinit var binding: ActivityContactRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        validateRegisterContacts()
        clearErrorOnType()
    }

    fun clearErrorOnType() {
        binding.tilName.addView(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilName.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.tilEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilEmail.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.tvphonenumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tvphonenumber.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    fun validateRegisterContacts() {
        val name = binding.ivperson.toString().trim()
        val contacts = binding.tvphonenumber.text.toString().trim()
        val email = binding.tilEmail.text.toString().trim()

        var error = false
        if (name.isBlank()) {
            binding.tilName.error = "Name is required"
            error = true
        }

        if (contacts.isBlank()) {
            binding.tvphonenumber.error = "Contacts is required"
            error = true
        }

        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }

        if (!error) {
            Toast.makeText(this, "$name, $contacts, $email", Toast.LENGTH_LONG).show()
        }
    }

    }

private fun TextInputLayout.addView(textWatcher: TextWatcher) {

}

