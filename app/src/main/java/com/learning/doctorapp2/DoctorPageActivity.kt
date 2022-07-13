package com.learning.doctorapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.learning.doctorapp2.databinding.ActivityDoctorPageBinding
import com.learning.doctorapp2.Test
import com.learning.doctorapp2.Test.consultant1

class DoctorPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.tVDoctorName.text = consultant1.name
        binding.tVDoctorStatus.text = consultant1.status.toString()
        binding.tVDoctorSpecialty.text = consultant1.speciality.toString()
        binding.iVDoctorProfilePhoto.setImageDrawable(AppCompatResources.getDrawable(this, consultant1.imageId))
    }
}