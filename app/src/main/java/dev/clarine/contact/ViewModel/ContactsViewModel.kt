package dev.clarine.contact.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.clarine.contact.Repository.ContactRepository
import dev.clarine.contact.model.ContactData
import kotlinx.coroutines.launch


    class ContactsViewModel : ViewModel() {
        val contactsRepo = ContactRepository()
        private lateinit var contactLiveData: LiveData<ContactData>
        fun getContactLiveData(): LiveData<ContactData> {
            return contactLiveData
        }
        fun getContactById(contactId: Int) {
            contactLiveData = contactsRepo.getContactById(contactId) as LiveData<ContactData>
        }
        fun saveContact(contact: ContactData) {
            viewModelScope.launch {
                contactsRepo.saveContact(contact)
            }
        }
        fun getContacts(): LiveData<List<ContactData>> {
            return contactsRepo.getDbContacts()
        }
}
