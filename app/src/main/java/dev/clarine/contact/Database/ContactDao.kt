package dev.clarine.contact.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.clarine.contact.model.ContactData

@Dao
interface ContactDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertContact(ContactData: ContactData)

  @Query("SELECT * FROM contacts ORDER BY displayName")
  fun getAllContacts(): LiveData<List<ContactData>>

  @Query("SELECT * FROM contacts WHERE contactId = :contactId")
  fun getContactById(contactId: Int): LiveData<ContactData>
}