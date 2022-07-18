package com.learning.doctorapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.learning.doctorapp2.databinding.ActivityConsultancyPageBinding

class ConsultancyPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityConsultancyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultancyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("doctor id")
        lateinit var thisConsultant: Consultant
        for (consultant in Test.consultantsList) {
            if(consultant.iD == id) {
                thisConsultant = consultant
            }
        }

        binding.bTRegister.setOnClickListener{
            Toast.makeText(this, "Consultant ${thisConsultant.name} will call you.", Toast.LENGTH_SHORT).show()
        }
    }
}