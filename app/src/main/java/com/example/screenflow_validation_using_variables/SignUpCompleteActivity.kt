package com.example.screenflow_validation_using_variables

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.screenflow_validation_using_variables.databinding.ActivitySignUpCompleteBinding

class SignUpCompleteActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySignUpCompleteBinding
    private var name = ""
    var txtString: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpCompleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = intent.extras?.get(FIRST_NAME_EXTRA) ?: "0"
        val surname = intent.extras?.get(SURNAME_EXTRA) ?: "1"
        name = firstName.toString() + " " + surname.toString()

        with(binding) {
            // Grabbing extras from intent
            nameResultTv.text = name.toString()
            emailResultTv.text = intent.getStringExtra(EMAIL_EXTRA)
            passwordResultTv.text = intent.getStringExtra(PASSWORD_EXTRA)
        }
    }
}
