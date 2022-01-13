package com.example.screenflow_validation_using_variables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.screenflow_validation_using_variables.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            startBtn.setOnClickListener{
                startSecondActivity()
            }
        }
    }

    private fun startSecondActivity(){
        // Start the second activity.
        val intent = Intent(this, NameActivity::class.java)
        startActivity(intent)
    }
}