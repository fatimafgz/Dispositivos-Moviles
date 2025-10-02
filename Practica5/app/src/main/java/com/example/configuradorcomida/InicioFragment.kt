package com.example.configuradorcomida

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * Fragmento inicial que permite comenzar un nuevo pedido
 * Autor: Fatima Florez Gonzalez
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 01/10/2025
 */
class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)

        val btnNuevoPedido = view.findViewById<Button>(R.id.btnNuevoPedido)
        btnNuevoPedido.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_seleccionComidaFragment)
        }

        return view
    }
}