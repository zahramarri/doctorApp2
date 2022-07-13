package com.learning.doctorapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.learning.doctorapp2.databinding.ActivityDoctorPageBinding
import com.learning.doctorapp2.Test.consultant1
import com.learning.doctorapp2.Test.consultancy1
import com.learning.doctorapp2.Test.consultancy2
import com.learning.doctorapp2.Test.consultancy3

class DoctorPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        binding.tVModeOfConsultancy1?.setOnClickListener {
            binding.bTAskConsultancy?.text = "Ask for " + binding.tVModeOfConsultancy1?.text
            binding.bTAskConsultancy?.visibility = View.VISIBLE
        }
        binding.tVModeOfConsultancy2?.setOnClickListener {
            binding.bTAskConsultancy?.text = "Ask for " + binding.tVModeOfConsultancy2?.text
            binding.bTAskConsultancy?.visibility = View.VISIBLE
        }
        binding.tVModeOfConsultancy3?.setOnClickListener {
            binding.bTAskConsultancy?.text = "Ask for " + binding.tVModeOfConsultancy3?.text
            binding.bTAskConsultancy?.visibility = View.VISIBLE
        }

        binding.bTAskConsultancy?.setOnClickListener{
            if (consultant1.status == Status.Offline) {
                Toast.makeText(this, "This consultant is not online. Sorry.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initViews() {
        binding.tVDoctorName.text = consultant1.name
        binding.tVDoctorStatus.text = consultant1.status.toString()
        binding.tVDoctorSpecialty.text = consultant1.speciality.toString()
        binding.iVDoctorProfilePhoto.setImageDrawable(
            AppCompatResources.getDrawable(
                this,
                consultant1.imageId
            )
        )

        binding.tVModeOfConsultancy1?.text = consultancy1.toString()
        binding.tVModeOfConsultancy2?.text = consultancy2.toString()
        binding.tVModeOfConsultancy3?.text = consultancy3.toString()
    }
}