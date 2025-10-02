package com.example.configuradorcomida

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


/**
 * Activity principal
 * Autor: Fatima Florez Gonzalez
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 01/10/2025
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }
}