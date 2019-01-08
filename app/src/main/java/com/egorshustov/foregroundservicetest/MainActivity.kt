package com.egorshustov.foregroundservicetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startService(v: View) {
        val input = edit_text_input.text.toString()
        val serviceIntent = Intent(this, ExampleService::class.java)
        serviceIntent.putExtra(INPUT_EXTRA, input)

        ContextCompat.startForegroundService(this, serviceIntent)
    }

    fun stopService(v: View) {
        val serviceIntent = Intent(this, ExampleService::class.java)
        stopService(serviceIntent)
    }

    companion object {
        const val INPUT_EXTRA = "com.egorshustov.foregroundservicetest.inputExtra"
    }
}
