package dev.clarine.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.clarine.contact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        displayContact()
    }
    fun displayContact(){
        var contact1=ContactData("","Mercy Atieno","25423678903","mercyatieno@gmail.com")
        var contact2=ContactData("","Mary Atieno","25423678903","mercyatieno@gmail.com")
        var contact3=ContactData("","Emma Atieno","25423678903","mercyatieno@gmail.com")
        var contact4=ContactData("","July Atieno","25423678903","mercyatieno@gmail.com")
        var contact5=ContactData("","Jay Atieno","25423678903","mercyatieno@gmail.com")
        var contact7=ContactData("","Jael Atieno","25423678903","mercyatieno@gmail.com")
        var contact8=ContactData("","Ann Atieno","25423678903","mercyatieno@gmail.com")
        var contact9=ContactData("","Melisa Wangari","25423678903","mercyatieno@gmail.com")
        var contactList= listOf<ContactData>(contact1,contact2,contact3,contact3,contact4,contact5,contact7,contact8,contact9)
        binding.rvContact.layoutManager=LinearLayoutManager(this)
        var contactAdapter=ContactRvAdapter(contactList)
        binding.rvContact.adapter=contactAdapter
    }

}