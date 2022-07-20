package com.learning.doctorapp2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.learning.doctorapp2.databinding.ActivityConsultancyPageBinding

class ConsultancyPageActivity : AppCompatActivity() {
    private lateinit var thisConsultant: Consultant
    private lateinit var binding: ActivityConsultancyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultancyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        val id = intent.getStringExtra("doctor id")
        thisConsultant = Test.getConsultant(id)!!

        binding.bTRegister.setOnClickListener{
            Toast.makeText(this, "Consultant ${thisConsultant.name} will call you.", Toast.LENGTH_SHORT).show()

            if (binding.eTVUserName.text.isNotBlank() &&
                binding.eTVUserPhoneNumber.text.isNotBlank()) {
                saveInSharedPref()
            }

            startActivityMentalCheck()
        }
    }
    private fun saveInSharedPref() {
        val sharedPref: SharedPreferences = getPreferences(MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString("user name", binding.eTVUserName.text.toString())
        editor.putString("user phone number", binding.eTVUserPhoneNumber.text.toString())
        editor.apply()
    }

    private fun readFormSharedPref(key: String): String? {
        val sharedPref: SharedPreferences = getPreferences(MODE_PRIVATE)
        return sharedPref.getString(key, "null")
    }

    private fun initViews() {
        val sharedPref: SharedPreferences = getPreferences(MODE_PRIVATE)
        val id = intent.getStringExtra("doctor id")
        thisConsultant = Test.getConsultant(id)!!

        if (readFormSharedPref("user name") != "null" &&
            readFormSharedPref("user phone number") != "null") {
            binding.eTVUserName.setText(sharedPref.getString("user name", "null"))
            binding.eTVUserPhoneNumber.setText(sharedPref.getString("user phone number", "null"))
        }
    }

    private fun startActivityMentalCheck() {
        val intent = Intent(this, MentalCheckActivity::class.java)
        startActivity(intent)
    }
}