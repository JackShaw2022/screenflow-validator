package com.example.screenflow_validation_using_variables

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.screenflow_validation_using_variables.databinding.ActivityPasswordBinding

class PasswordActivity: AppCompatActivity() {
    // Bind the name activity.
    private lateinit var binding: ActivityPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
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
        val email = intent.getStringExtra(EMAIL_EXTRA)
        // Bind the password.
        val password = binding.passwordEt.text.toString()

        // Store the current data in the current intent.
        val intent = Intent(this, SignUpCompleteActivity::class.java).also {
            it.putExtra(FIRST_NAME_EXTRA, firstName)
            it.putExtra(SURNAME_EXTRA, surname)
            it.putExtra(EMAIL_EXTRA, email)
            it.putExtra(PASSWORD_EXTRA, password)
        }

        // Start the password activity.
        startActivity(intent)
    }

}
