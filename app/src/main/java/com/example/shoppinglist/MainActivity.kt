package com.example.shoppinglist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTheme(android.R.style.Theme_Black)

        val navShoppingListButton: Button = findViewById (R.id.navShoppingList)

        navShoppingListButton.setOnClickListener() {
            val intent = Intent(this, ProductListActivity::class.java)
            startActivity(intent)
        }

        val navOptionsButton: Button = findViewById (R.id.navOptions)

        navOptionsButton.setOnClickListener() {
            val intent = Intent(this, OptionsActivity::class.java)
            startActivity(intent)
        }
    }
}