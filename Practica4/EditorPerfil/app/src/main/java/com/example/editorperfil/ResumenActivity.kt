package com.example.editorperfil
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    private lateinit var tvNombre: TextView
    private lateinit var tvEdad: TextView
    private lateinit var tvCiudad: TextView
    private lateinit var tvCorreo: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnVolverEditar: Button

    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        inicializarVistas()
        obtenerDatosUsuario()
        mostrarDatosUsuario()
        configurarBotones()
    }

    private fun inicializarVistas() {
        tvNombre = findViewById(R.id.tvNombre)
        tvEdad = findViewById(R.id.tvEdad)
        tvCiudad = findViewById(R.id.tvCiudad)
        tvCorreo = findViewById(R.id.tvCorreo)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnVolverEditar = findViewById(R.id.btnVolverEditar)
    }

    private fun obtenerDatosUsuario() {
        usuario = intent.getSerializableExtra("USUARIO") as Usuario
    }

    private fun mostrarDatosUsuario() {
        tvNombre.text = usuario.nombre
        tvEdad.text = usuario.edad
        tvCiudad.text = usuario.ciudad
        tvCorreo.text = usuario.correo
    }

    private fun configurarBotones() {
        btnConfirmar.setOnClickListener {
            confirmarPerfil()
        }
        btnVolverEditar.setOnClickListener {
            volverAEditar()
        }
    }

    private fun confirmarPerfil() {
        val resultIntent = Intent().apply {
            putExtra("RESULTADO", "CONFIRMADO")
        }
        setResult(RESULT_OK, resultIntent)
        finish()
    }

    private fun volverAEditar() {
        setResult(RESULT_CANCELED)
        finish()
    }
}