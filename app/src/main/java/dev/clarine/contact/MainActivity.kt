package dev.clarine.contact

import android.content.Intent
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


        binding.faAdd.setOnClickListener {
            val intent = Intent(this,ContactRegister::class.java)
            startActivity(intent)
        }

    }


    override fun onResume() {
        super.onResume()


        displayContact()
    }
    fun displayContact(){
        var contact1=ContactData("https://images.unsplash.com/photo-1533973427779-4b8c2eb4c3cd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80","Mercy Atieno","25423678903","mercyatieno@gmail.com")
        var contact2=ContactData("https://images.unsplash.com/photo-1508184964240-ee96bb9677a7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80","Mary Atieno","25423678903","mercyatieno@gmail.com")
        var contact3=ContactData("https://images.unsplash.com/photo-1484517186945-df8151a1a871?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=449&q=80","Emma Atieno","25423678903","mercyatieno@gmail.com")
        var contact4=ContactData("https://images.unsplash.com/photo-1541216970279-affbfdd55aa8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80","July Atieno","25423678903","mercyatieno@gmail.com")
        var contact5=ContactData("https://images.unsplash.com/photo-1527201987695-67c06571957e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=404&q=80","Jay Atieno","25423678903","mercyatieno@gmail.com")
        var contact6=ContactData("https://images.unsplash.com/photo-1514222709107-a180c68d72b4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=449&q=80","Jael Atieno","25423678903","mercyatieno@gmail.com")
        var contact7=ContactData("https://images.unsplash.com/photo-1495846101638-bd8e9a23f8ee?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80","Ann Atieno","25423678903","mercyatieno@gmail.com")
        var contact8=ContactData("https://images.unsplash.com/photo-1512361436605-a484bdb34b5f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80","Melisa Wangari","25423678903","mercyatieno@gmail.com")
        var contactList= listOf<ContactData>(contact1,contact2,contact3,contact4,contact5,contact6,contact7,contact8)
        binding.rvContact.layoutManager=LinearLayoutManager(this)
        var contactAdapter=ContactRvAdapter(contactList)
        binding.rvContact.adapter=contactAdapter
    }


}