package com.learning.doctorapp2

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.learning.doctorapp2.databinding.ActivityConsultancyPageBinding

class ConsultancyPageActivity : AppCompatActivity() {
    private fun startActivityMentalCheck() {
//        val intent = Intent(this, MentalCheckActivity::class.java)
//        startActivity(intent)

        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                Toast.makeText(this , intent?.getStringExtra("myStr"), Toast.LENGTH_SHORT).show()
                // Handle the Intent
            }
        }
        val intent = Intent(this , MentalCheckActivity::class.java)
        startForResult.launch(intent)
    }
    private lateinit var thisConsultant: Consultant
    private lateinit var binding: ActivityConsultancyPageBinding
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            Toast.makeText(this , "${intent?.getDoubleExtra(EXTRA_NAME, 0.0)}", Toast.LENGTH_SHORT).show()
            // Handle the Intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityConsultancyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        binding.bTRegister.setOnClickListener{
            if (binding.eTVUserName.text.isNotBlank() &&
                binding.eTVUserPhoneNumber.text.isNotBlank()) {
                saveInSharedPref()
            }

            val intent = Intent(this , MentalCheckActivity::class.java)
            startForResult.launch(intent)

            Toast.makeText(this, "Consultant ${thisConsultant.name} will call you.", Toast.LENGTH_SHORT).show()
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
        thisConsultant = Test.getConsultant(id!!)

        if (readFormSharedPref("user name") != "null" &&
            readFormSharedPref("user phone number") != "null") {
            binding.eTVUserName.setText(sharedPref.getString("user name", "null"))
            binding.eTVUserPhoneNumber.setText(sharedPref.getString("user phone number", "null"))
        }
    }


}