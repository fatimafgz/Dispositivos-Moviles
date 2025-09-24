/*
Descripción: Editor de nota rápido - Permitir al usuario escribir una nota, enviarla a otra actividad para elegir compartirla o volver a editar.
Autor: Fatima Florez Gonzalez
Fecha creación: 24/09/2025
Fecha última modificación: 24/09/2025
*/

package com.example.editornotas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OpcionesActivity : AppCompatActivity() {

    private lateinit var tvNota: TextView
    private lateinit var btnCompartirCorreo: Button
    private lateinit var btnEditarNuevo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        inicializarVistas()
        mostrarNotaRecibida()
        configurarBotones()
    }

    private fun inicializarVistas() {
        tvNota = findViewById(R.id.tvNota)
        btnCompartirCorreo = findViewById(R.id.btnCompartirCorreo)
        btnEditarNuevo = findViewById(R.id.btnEditarNuevo)
    }

    private fun mostrarNotaRecibida() {
        val notaRecibida = intent.getStringExtra("nota")
        tvNota.text = notaRecibida ?: "No hay nota para mostrar"
    }

    private fun configurarBotones() {
        btnCompartirCorreo.setOnClickListener {
            android.widget.Toast.makeText(
                this,
                "Compartido por correo",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }

        btnEditarNuevo.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}