import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../viewmodels/user_view_model.dart';
import '../models/user.dart';
import 'user_form_screen.dart';

class UserListScreen extends StatelessWidget {
  final String email;

  const UserListScreen({super.key, required this.email});

  @override
  Widget build(BuildContext context) {
    final viewModel = context.watch<UserViewModel>();

    return Scaffold(
      appBar: AppBar(
        title: Text('Bienvenido: $email'),
        actions: [
          // Switch para filtrar usuarios activos
          Row(
            children: [
              const Text('Solo Activos', style: TextStyle(fontSize: 14)),
              Switch(
                value: viewModel.mostrarSoloActivos,
                onChanged: (value) => viewModel.setFiltroActivos(value),
              ),
            ],
          ),
        ],
      ),
      body: Column(
        children: [
          // Contador de usuarios
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              'Mostrando ${viewModel.usuarios.length} usuario(s)'
                  '${viewModel.mostrarSoloActivos ? ' (Filtrado)' : ''}',
              style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
            ),
          ),
          Expanded(
            child: viewModel.usuarios.isEmpty
                ? const Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(Icons.people_outline, size: 64, color: Colors.grey),
                  SizedBox(height: 16),
                  Text('No hay usuarios para mostrar'),
                  Text('¡Agrega el primero!'),
                ],
              ),
            )
                : ListView.builder(
              itemCount: viewModel.usuarios.length,
              itemBuilder: (context, index) {
                final user = viewModel.usuarios[index];
                return Card(
                  margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 4),
                  color: user.activo ? null : Colors.grey[200],
                  child: ListTile(
                    leading: CircleAvatar(
                      backgroundColor: user.activo ? Colors.indigo : Colors.grey,
                      child: Text(
                        user.nombre[0].toUpperCase(),
                        style: const TextStyle(color: Colors.white),
                      ),
                    ),
                    title: Text(user.nombre),
                    subtitle: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text('Edad: ${user.edad} años'),
                        Text('Género: ${user.genero}'),
                        Text('Correo: ${user.correo}'),
                        Text(
                          user.activo ? 'Activo' : 'Inactivo',
                          style: TextStyle(
                            color: user.activo ? Colors.green : Colors.red,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ],
                    ),
                    trailing: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        IconButton(
                          icon: const Icon(Icons.edit),
                          onPressed: () async {
                            final actualizado = await Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (_) => UserFormScreen(
                                  usuario: user,
                                  indice: index,
                                ),
                              ),
                            );
                            if (actualizado != null && actualizado is User) {
                              viewModel.editarUsuario(index, actualizado);
                            }
                          },
                        ),
                        IconButton(
                          icon: const Icon(Icons.delete, color: Colors.red),
                          onPressed: () => _mostrarDialogoEliminar(context, index, viewModel),
                        ),
                      ],
                    ),
                  ),
                );
              },
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          final nuevoUsuario = await Navigator.push(
            context,
            MaterialPageRoute(builder: (_) => const UserFormScreen()),
          );
          if (nuevoUsuario != null && nuevoUsuario is User) {
            viewModel.agregarUsuario(nuevoUsuario);
          }
        },
        child: const Icon(Icons.add),
      ),
    );
  }

  // Confirmación antes de eliminar usuario 
  void _mostrarDialogoEliminar(BuildContext context, int index, UserViewModel viewModel) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Eliminar usuario'),
        content: const Text('¿Estás seguro de que quieres eliminar este usuario?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('Cancelar'),
          ),
          TextButton(
            onPressed: () {
              viewModel.eliminarUsuario(index);
              Navigator.pop(context);
            },
            child: const Text('Eliminar', style: TextStyle(color: Colors.red)),
          ),
        ],
      ),
    );
  }
}