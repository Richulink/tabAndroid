package com.example.tabmenu

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.hide() // Aquí se oculta la ActionBar
     //   supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //fragment anidado
    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
            val themePreference = findPreference<SwitchPreferenceCompat>("theme_preference")
            themePreference?.setOnPreferenceChangeListener { preference, newValue ->
                if (newValue as Boolean) {
                    // El usuario ha cambiado la preferencia a 'true'
                    // Cambia el tema a oscuro
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    // El usuario ha cambiado la preferencia a 'false'
                    // Cambia el tema a claro
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("theme_dark", newValue).apply()
                true
            }
        }

    }
}