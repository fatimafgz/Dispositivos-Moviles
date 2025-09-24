/*
Descripción: Editor de perfil con confirmación - Crear una app que permita llenar un perfil de usuario, mostrar los datos en otra pantalla y confirmar si está correcto..
Autor: Fatima Florez Gonzalez
Fecha creación: 24/09/2025
Fecha última modificación: 24/09/2025
*/


package com.example.editorperfil
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnContinuar: Button

    private val resultadoActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            android.widget.Toast.makeText(
                this,
                "Perfil guardado correctamente",
                android.widget.Toast.LENGTH_SHORT
            ).show()
            limpiarFormulario()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        inicializarVistas()
        restaurarDatos(savedInstanceState)
        configurarBotones()
    }

    private fun inicializarVistas() {
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)
    }

    private fun configurarBotones() {
        btnContinuar.setOnClickListener {
            if (validarFormulario()) {
                enviarDatosAResumen()
            }
        }
    }

    private fun validarFormulario(): Boolean {
        val nombre = etNombre.text.toString().trim()
        val edad = etEdad.text.toString().trim()
        val ciudad = etCiudad.text.toString().trim()
        val correo = etCorreo.text.toString().trim()

        if (nombre.isEmpty()) {
            etNombre.error = "Ingrese su nombre"
            return false
        }
        if (edad.isEmpty()) {
            etEdad.error = "Ingrese su edad"
            return false
        }
        if (ciudad.isEmpty()) {
            etCiudad.error = "Ingrese su ciudad"
            return false
        }
        if (correo.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.error = "Ingrese un correo válido"
            return false
        }
        return true
    }

    private fun enviarDatosAResumen() {
        val usuario = Usuario(
            nombre = etNombre.text.toString(),
            edad = etEdad.text.toString(),
            ciudad = etCiudad.text.toString(),
            correo = etCorreo.text.toString()
        )

        val intent = Intent(this, ResumenActivity::class.java).apply {
            putExtra("USUARIO", usuario)
        }
        resultadoActivity.launch(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("NOMBRE", etNombre.text.toString())
        outState.putString("EDAD", etEdad.text.toString())
        outState.putString("CIUDAD", etCiudad.text.toString())
        outState.putString("CORREO", etCorreo.text.toString())
    }

    private fun restaurarDatos(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            etNombre.setText(it.getString("NOMBRE", ""))
            etEdad.setText(it.getString("EDAD", ""))
            etCiudad.setText(it.getString("CIUDAD", ""))
            etCorreo.setText(it.getString("CORREO", ""))
        }
    }

    private fun limpiarFormulario() {
        etNombre.text.clear()
        etEdad.text.clear()
        etCiudad.text.clear()
        etCorreo.text.clear()
    }
}