package com.learning.doctorapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.doctorapp2.databinding.ActivityMentalCheckBinding

const val EXTRA_NAME = "Mental Health Percentage"
class MentalCheckActivity : AppCompatActivity() {
    lateinit var binding: ActivityMentalCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMentalCheckBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btDone.setOnClickListener{

            returnResult(calculateMentalHealthPercentage())

        }

    }

    private fun calculateMentalHealthPercentage(): Double {
        var percentage = 0.0
        if (binding.checkBoxQuestion1.isChecked) {
            percentage += 33.33
        }
        if (binding.checkBoxQuestion2.isChecked) {
            percentage += 33.33
        }
        if (binding.checkBoxQuestion3.isChecked) {
            percentage += 33.33
        }
        return percentage
    }

    private fun returnResult(mentalHealthPercentage: Double){
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_NAME , mentalHealthPercentage)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
}