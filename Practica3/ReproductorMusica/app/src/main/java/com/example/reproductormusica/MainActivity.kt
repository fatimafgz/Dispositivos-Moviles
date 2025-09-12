/*
Descripción: Reproductor de música básico con botones para reproducir, pausar y detener.
Autor: Fatima Florez Gonzalez
Fecha creación: 11/09/2025
Fecha última modificación: 12/09/2025
*/

package com.example.reproductormusica

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializamos el MediaPlayer con el archivo en res/raw
        mediaPlayer = MediaPlayer.create(this, R.raw.theenterteiner)

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnStop = findViewById<Button>(R.id.btnStop)

        // Botón Reproducir
        btnPlay.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }

        // Botón Pausar
        btnPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        // Botón Detener
        btnStop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer = MediaPlayer.create(this, R.raw.theenterteiner) // reiniciar
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Liberar recursos al cerrar la app
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}
