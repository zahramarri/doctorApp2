package com.learning.doctorapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.doctorapp2.databinding.ActivityMentalCheckBinding

class MentalCheckActivity : AppCompatActivity() {
    lateinit var binding: ActivityMentalCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMentalCheckBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}