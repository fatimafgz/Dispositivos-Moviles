package com.example.configuradorcomida

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * Fragmento para seleccionar el tipo de comida principal
 * Autor: Fatima Florez Gonzalez
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 01/10/2025
 */
class SeleccionComidaFragment : Fragment() {

    private var tipoComidaSeleccionada = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_comida, container, false)

        // Recibir datos si viene de edición
        parentFragmentManager.setFragmentResultListener("pedidoData", this) { requestKey, bundle ->
            tipoComidaSeleccionada = bundle.getString("tipoComida", "")
            actualizarSeleccion(view)
        }

        // Configurar RadioGroup
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupComida)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            tipoComidaSeleccionada = when (checkedId) {
                R.id.radioPizza -> getString(R.string.opcion_pizza)
                R.id.radioHamburguesa -> getString(R.string.opcion_hamburguesa)
                R.id.radioEnsalada -> getString(R.string.opcion_ensalada)
                else -> ""
            }
        }

        // Botón Siguiente
        view.findViewById<Button>(R.id.btnSiguiente).setOnClickListener {
            if (tipoComidaSeleccionada.isNotEmpty()) {
                val bundle = Bundle().apply {
                    putString("tipoComida", tipoComidaSeleccionada)
                }
                findNavController().navigate(
                    R.id.action_seleccionComidaFragment_to_seleccionExtrasFragment,
                    bundle
                )
            } else {
                Toast.makeText(requireContext(), getString(R.string.error_selecciona_comida), Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun actualizarSeleccion(view: View) {
        val radioId = when (tipoComidaSeleccionada) {
            "Pizza" -> R.id.radioPizza
            "Hamburguesa" -> R.id.radioHamburguesa
            "Ensalada" -> R.id.radioEnsalada
            else -> -1
        }
        if (radioId != -1) {
            view.findViewById<RadioGroup>(R.id.radioGroupComida)?.check(radioId)
        }
    }
}