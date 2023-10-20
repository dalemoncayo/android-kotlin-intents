package com.dalemncy.demo.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dalemncy.demo.intents.constants.Constants
import com.dalemncy.demo.intents.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the parameter coming from PersonAdapter.
        // Default value for getIntExtra is 0 if PARAM_ID turns up to be null.
        val id = intent.getIntExtra(Constants.PARAM_ID, 0)

        // Get the parameter coming from PersonAdapter.
        // Default value for 'getStringExtra' is null.
        val name = intent.getStringExtra(Constants.PARAM_NAME)
        val email = intent.getStringExtra(Constants.PARAM_EMAIL)

        val title = "[$id] $name"

        binding.name.text = title
        binding.email.text = email
    }
}