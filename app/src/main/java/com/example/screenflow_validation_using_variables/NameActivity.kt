package com.example.screenflow_validation_using_variables

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.screenflow_validation_using_variables.databinding.ActivityNameBinding

class NameActivity: AppCompatActivity() {
    // Bind the name activity.
    private lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            nextBtn.setOnClickListener {
                startEmailActivity()
            }
        }
    }

        private fun startEmailActivity(){
            // Get first name, and get last name.
            val firstName = binding.firstNameEt.text.toString()
            val surname = binding.surnameEt.text.toString()

            // Store the first name and last name.
            val intent = Intent(this, EmailActivity::class.java).also {
                it.putExtra(FIRST_NAME_EXTRA, firstName)
                it.putExtra(SURNAME_EXTRA, surname)
            }

            // Start the email activity.
            startActivity(intent)
        }
}