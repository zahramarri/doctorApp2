package com.learning.doctorapp2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.learning.doctorapp2.databinding.ActivityDoctorPageBinding
import com.learning.doctorapp2.Test.consultant1
import com.learning.doctorapp2.Test.consultancy1
import com.learning.doctorapp2.Test.consultancy2
import com.learning.doctorapp2.Test.consultancy3
import com.learning.doctorapp2.Test.consultant2

class DoctorPageActivity : AppCompatActivity() {
    private val name = "doctor id"
    lateinit var binding: ActivityDoctorPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            with(savedInstanceState) {
                binding.bTAskConsultancy?.visibility = getInt(STATE_BUTTON_VISIBILITY)
                binding.bTAskConsultancy?.text = getString(STATE_BUTTON_TEXT)
            }
        }

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

            startConsultancyActivity()
        }

        binding.bTCall.setOnClickListener{
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:09124132891")
            startActivity(callIntent)
        }
    }

    private fun startConsultancyActivity() {
        val intent = Intent(this, ConsultancyPageActivity::class.java)
        intent.putExtra(name, consultant2.iD)
        startActivity(intent)
    }

    private fun initViews() {
        binding.tVDoctorName.text = consultant2.name
        binding.tVDoctorStatus.text = consultant2.status.toString()
        binding.tVDoctorSpecialty.text = consultant2.speciality.toString()
        binding.iVDoctorProfilePhoto.setImageDrawable(
            AppCompatResources.getDrawable(
                this,
                consultant2.imageId
            )
        )

        binding.tVModeOfConsultancy1?.text = consultancy1.toString()
        binding.tVModeOfConsultancy2?.text = consultancy2.toString()
        binding.tVModeOfConsultancy3?.text = consultancy3.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            binding.bTAskConsultancy?.let {
                putInt(STATE_BUTTON_VISIBILITY, it.visibility)
                putString(STATE_BUTTON_TEXT, it.text.toString())
            }
        }
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemShare -> {
                shareDoctor()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareDoctor() {
        TODO("Not yet implemented")
    }

    companion object {
        private const val STATE_BUTTON_VISIBILITY = "button ask consultancy visibility"
        private const val STATE_BUTTON_TEXT = "button ask consultancy text"
    }
}