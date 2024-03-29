package com.moataz.afternoonhadeeth.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.moataz.afternoonhadeeth.data.model.Hadith
import com.moataz.afternoonhadeeth.databinding.ActivityMainBinding
import com.moataz.afternoonhadeeth.notification.NotificationAfternoon
import com.moataz.afternoonhadeeth.utils.IntentHelpers
import com.moataz.afternoonhadeeth.utils.ViewHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewHelper.intiViews(window)
        NotificationAfternoon().setupAfternoonNotification(this)
        setOnClickToolbarIcons()
        setupHadithText()
        getHadith()
    }

    private fun setOnClickToolbarIcons() {
        binding.twitter.setOnClickListener {
            IntentHelpers.openTwitterAccountIntent(this)
        }

        binding.instagram.setOnClickListener {
            IntentHelpers.openInstagramAccountIntent(this)
        }

        binding.support.setOnClickListener {
            // write your code here
        }
    }

    private fun setupHadithText() {
        binding.firstHadith.text = Hadith().firstHadith()
        binding.firstHadith.movementMethod = ScrollingMovementMethod() // scroll the text

        binding.secondHadith.text = Hadith().secondHadith()
        binding.secondHadith.movementMethod = ScrollingMovementMethod()
    }

    private fun getHadith() {
        binding.getHadithButton.setOnClickListener { setupHadithText() }
    }
}