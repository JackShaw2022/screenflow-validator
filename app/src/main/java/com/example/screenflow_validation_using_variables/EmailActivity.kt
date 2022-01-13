package com.example.screenflow_validation_using_variables

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.screenflow_validation_using_variables.databinding.ActivityEmailBinding

class EmailActivity: AppCompatActivity() {
    // Bind the name activity.
    private lateinit var binding: ActivityEmailBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            nextBtn.setOnClickListener {
                startEmailActivity()
            }
        }
    }

    private fun startEmailActivity(){
        // Get the previous intent.
        val firstName = intent.getStringExtra(FIRST_NAME_EXTRA)
        val surname = intent.getStringExtra(SURNAME_EXTRA)

        // Bind the email.
        val email = binding.emailEt.text.toString()

        // Store the current data in the current intent.
        val intent = Intent(this, PasswordActivity::class.java).also {
            it.putExtra(FIRST_NAME_EXTRA, firstName)
            it.putExtra(SURNAME_EXTRA, surname)
            it.putExtra(EMAIL_EXTRA, email)
        }

        // Start the password activity.
        startActivity(intent)
    }
}
