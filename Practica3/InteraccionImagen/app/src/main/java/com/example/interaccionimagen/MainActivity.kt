/*
    Descripción: Aplicación básica en Android que muestra una imagen y al hacer clic en ella despliega un Toast.
    Autor: Fatima
    Fecha de creación: 11/09/2025
    Fecha última modificación: 11/09/2025
*/

package com.example.interaccionimagen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia a la imagen en el layout
        val imageView: ImageView = findViewById(R.id.miImagen)

        // Programamos la acción al hacer clic en la imagen
        imageView.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.toast_message),  // Así se usa strings.xml
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
