package com.example.configuradorcomida

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * Fragmento para seleccionar extras del pedido
 * Autor: Fatima Florez Gonzalez
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 01/10/2025
 */
class SeleccionExtrasFragment : Fragment() {

    private val extrasSeleccionados = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_extras, container, false)

        // Recibir tipo de comida del fragment anterior
        val tipoComida = arguments?.getString("tipoComida") ?: ""

        // Configurar CheckBoxes
        val checkBebida = view.findViewById<CheckBox>(R.id.checkBebida)
        val checkPapas = view.findViewById<CheckBox>(R.id.checkPapas)
        val checkPostre = view.findViewById<CheckBox>(R.id.checkPostre)

        val checkboxes = listOf(checkBebida, checkPapas, checkPostre)

        checkboxes.forEach { checkbox ->
            checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
                val extra = when (buttonView.id) {
                    R.id.checkBebida -> getString(R.string.extra_bebida)
                    R.id.checkPapas -> getString(R.string.extra_papas)
                    R.id.checkPostre -> getString(R.string.extra_postre)
                    else -> ""
                }
                if (isChecked && !extrasSeleccionados.contains(extra)) {
                    extrasSeleccionados.add(extra)
                } else if (!isChecked) {
                    extrasSeleccionados.remove(extra)
                }
            }
        }

        // Botón Siguiente
        view.findViewById<Button>(R.id.btnSiguienteExtras).setOnClickListener {
            val bundle = Bundle().apply {
                putString("tipoComida", tipoComida)
                putStringArrayList("extras", ArrayList(extrasSeleccionados))
            }
            findNavController().navigate(
                R.id.action_seleccionExtrasFragment_to_resumenPedidoFragment,
                bundle
            )
        }

        return view
    }
}