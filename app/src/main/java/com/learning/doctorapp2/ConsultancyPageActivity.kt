package com.learning.doctorapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.learning.doctorapp2.databinding.ActivityConsultancyPageBinding

class ConsultancyPageActivity : AppCompatActivity() {
    lateinit var thisConsultant: Consultant
    lateinit var binding: ActivityConsultancyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultancyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        binding.bTRegister.setOnClickListener{
            Toast.makeText(this, "Consultant ${thisConsultant.name} will call you.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViews() {
        val id = intent.getStringExtra("doctor id")
        thisConsultant = Test.getConsultant(id)!!
    }
}