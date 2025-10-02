package com.example.configuradorcomida

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * Fragmento para mostrar resumen del pedido y confirmar
 * Autor: Fatima Florez Gonzalez
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 01/10/2025
 */
class ResumenPedidoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resumen_pedido, container, false)

        // Obtener datos del pedido
        val tipoComida = arguments?.getString("tipoComida") ?: "No seleccionado"
        val extras = arguments?.getStringArrayList("extras") ?: mutableListOf()

        // Mostrar resumen
        val txtResumen = view.findViewById<TextView>(R.id.txtResumen)
        val resumen = """
            ${getString(R.string.comida, tipoComida)}
    ${getString(R.string.extras, if (extras.isEmpty()) getString(R.string.ninguno) else extras.joinToString(", "))}
""".trimIndent()
        txtResumen.text = resumen

        // Botón Confirmar
        view.findViewById<Button>(R.id.btnConfirmar).setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.pedido_confirmado), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_resumenPedidoFragment_to_inicioFragment)
        }

        // Botón Editar
        view.findViewById<Button>(R.id.btnEditar).setOnClickListener {
            // Enviar datos actuales al fragment anterior
            val resultBundle = Bundle().apply {
                putString("tipoComida", tipoComida)
                putStringArrayList("extras", ArrayList(extras))
            }
            parentFragmentManager.setFragmentResult("pedidoData", resultBundle)

            // Regresar al fragment de selección de comida
            findNavController().navigate(R.id.action_resumenPedidoFragment_to_seleccionComidaFragment)
        }

        return view
    }
}