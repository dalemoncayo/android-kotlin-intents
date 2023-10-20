package com.dalemncy.demo.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dalemncy.demo.intents.adapters.PersonAdapter
import com.dalemncy.demo.intents.databinding.ActivityMainBinding
import com.dalemncy.demo.intents.models.Person

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        val persons: MutableList<Person> = ArrayList()

        for (i in 1..10) { // Loop 10 times to make the list longer.
            persons.add(Person(10 + i, "John Doe", "john.doe@gmail.com"))
            persons.add(Person(11 + i, "Saturo Gojo", "saturo.gojo@gmail.om"))
            persons.add(Person(12 + i, "Monkey D. Luffy", "monkey.luffy@gmail.com"))
            persons.add(Person(23 + i, "Naruto Uzumaki", "naruto.uzumaki@gmail.com"))
        }

        binding.personList.layoutManager = LinearLayoutManager(this)
        binding.personList.adapter = PersonAdapter(
            this, // Adding this parameter since we need the context of the current screen.
            persons
        )
    }
}