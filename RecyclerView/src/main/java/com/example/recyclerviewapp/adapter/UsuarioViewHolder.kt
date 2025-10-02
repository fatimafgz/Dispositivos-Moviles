package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.Usuario

class UsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val txtNombre = view.findViewById<TextView>(R.id.txtNombre)
    private val txtEdad = view.findViewById<TextView>(R.id.txtEdad)
    private val txtCorreo = view.findViewById<TextView>(R.id.txtCorreo)
    private val btnDelete = view.findViewById<ImageButton>(R.id.btnEliminar)

    private lateinit var currentUser: Usuario

    fun bind(user: Usuario, onDelete: (Int) -> Unit, onEdit: (Int, Usuario) -> Unit) {
        currentUser = user
        txtNombre.text = user.nombre
        txtEdad.text = user.edad.toString()
        txtCorreo.text = user.email

        btnDelete.setOnClickListener {
            val pos = bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                onDelete(pos)
            }
        }

        itemView.setOnLongClickListener {
            val pos = bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                mostrarMenuOpciones(pos, onDelete, onEdit)
            }
            true
        }
    }

    private fun mostrarMenuOpciones(pos: Int, onDelete: (Int) -> Unit, onEdit: (Int, Usuario) -> Unit) {
        AlertDialog.Builder(itemView.context)
            .setTitle("Acción")
            .setItems(arrayOf("Editar", "Eliminar")) { _, which ->
                when (which) {
                    0 -> showEditDialog(currentUser, onEdit)
                    1 -> onDelete(pos)
                }
            }
            .show()
    }

    private fun showEditDialog(usuario: Usuario, onEdit: (Int, Usuario) -> Unit) {
        val context = itemView.context

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_usuario, null)

        val editNombre = dialogView.findViewById<EditText>(R.id.editNombre)
        val editEdad = dialogView.findViewById<EditText>(R.id.editEdad)
        val editCorreo = dialogView.findViewById<EditText>(R.id.editCorreo)

        editNombre.setText(usuario.nombre)
        editEdad.setText(usuario.edad.toString())
        editCorreo.setText(usuario.email)


        AlertDialog.Builder(context)
            .setTitle("Editar usuario")
            .setView(dialogView)
            .setPositiveButton("Guardar") { _, _ ->
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    // 5. ACTUALIZAR EL USUARIO
                    usuario.nombre = editNombre.text.toString()
                    usuario.edad = editEdad.text.toString().toIntOrNull() ?: usuario.edad
                    usuario.email = editCorreo.text.toString()
                    onEdit(pos, usuario)
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}