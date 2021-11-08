package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        val actionBar = supportActionBar
        actionBar!!.title = "Options"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}