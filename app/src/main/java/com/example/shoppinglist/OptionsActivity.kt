package com.example.shoppinglist

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.shoppinglist.databinding.ActivityOptionsBinding

class OptionsActivity : AppCompatActivity() {

    private  val TAG = "OptionsActivity"
    private lateinit var sp: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        sp = getPreferences(Context.MODE_PRIVATE)
        editor = sp.edit()

        val binding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btgTheme.check(sp.getInt("THEME", R.id.btnDefault))

        binding.btgTheme.addOnButtonCheckedListener { _, selectedBtnId, isChecked ->
            if (isChecked) {
                val theme = when (selectedBtnId) {
                    R.id.btnDefault -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    R.id.btnDark -> AppCompatDelegate.MODE_NIGHT_YES
                    else -> AppCompatDelegate.MODE_NIGHT_NO
                }
                Log.d(TAG, "isChecked:$isChecked theme:$theme")
                //                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -- default
                //                AppCompatDelegate.MODE_NIGHT_YES -dark
                //                AppCompatDelegate.MODE_NIGHT_NO - light
                AppCompatDelegate.setDefaultNightMode(theme)

                editor.apply{
                    putInt( "THEME", selectedBtnId )
                }
            }
        }
    }
}