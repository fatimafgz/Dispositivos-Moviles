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
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class EditorActivity : AppCompatActivity() {

    private lateinit var etNota: EditText
    private lateinit var btnCompartir: Button

    private val resultadoOpciones = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            // Podríamos recibir datos de vuelta si fuera necesario
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        inicializarVistas()
        restaurarTexto(savedInstanceState)
        configurarBotones()
    }

    private fun inicializarVistas() {
        etNota = findViewById(R.id.etNota)
        btnCompartir = findViewById(R.id.btnCompartir)
    }

    private fun configurarBotones() {
        btnCompartir.setOnClickListener {
            compartirNota()
        }
    }

    private fun compartirNota() {
        val textoNota = etNota.text.toString().trim()

        if (textoNota.isEmpty()) {
            etNota.error = getString(R.string.error_campo_vacio)
            return
        }

        val intent = Intent(this, OpcionesActivity::class.java).apply {
            putExtra("nota", textoNota)
        }

        resultadoOpciones.launch(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("texto_nota", etNota.text.toString())
    }

    private fun restaurarTexto(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            val textoSguardado = it.getString("texto_nota", "")
            etNota.setText(textoSguardado)
        }
    }
}