package com.learning.doctorapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.doctorapp2.databinding.ActivityDoctorPageBinding

class DoctorPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}