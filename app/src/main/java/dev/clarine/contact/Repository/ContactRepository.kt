package dev.clarine.contact.Repository

import androidx.lifecycle.LiveData
import dev.clarine.contact.Database.ContactsDb
import dev.clarine.contact.contactApp
import dev.clarine.contact.model.ContactData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactRepository {
     val database = ContactsDb.getDataBase(contactApp.appContext)

    suspend fun saveContact(contactData: ContactData) {
        withContext(Dispatchers.IO) {
            database.contactDao().insertContact(contactData)
        }
    }

    fun getDbContacts(): LiveData<List<ContactData>> {
        return database.contactDao().getAllContacts()
    }

    fun getContactById(contactId: Int): LiveData<ContactData>{
        return database.contactDao().getContactById(contactId)
    }
}
