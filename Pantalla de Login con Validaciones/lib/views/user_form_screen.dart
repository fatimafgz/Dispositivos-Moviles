import 'package:flutter/material.dart';
import '../models/user.dart';

class UserFormScreen extends StatefulWidget {
  final User? usuario;
  final int? indice;

  const UserFormScreen({super.key, this.usuario, this.indice});

  @override
  State<UserFormScreen> createState() => _UserFormScreenState();
}

class _UserFormScreenState extends State<UserFormScreen> {
  final _formKey = GlobalKey<FormState>();
  late String _nombre;
  String _genero = 'Masculino';
  bool _activo = true;
  late String _edad;
  late String _correo;

  @override
  void initState() {
    super.initState();
    if (widget.usuario != null) {
      _nombre = widget.usuario!.nombre;
      _genero = widget.usuario!.genero;
      _activo = widget.usuario!.activo;
      _edad = widget.usuario!.edad.toString();
      _correo = widget.usuario!.correo;
    } else {
      _nombre = '';
      _edad = '';
      _correo = '';
    }
  }

  // Validación de correo electrónico
  bool _esCorreoValido(String email) {
    final regex = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
    return regex.hasMatch(email);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.usuario == null ? 'Agregar Usuario' : 'Editar Usuario'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: ListView(
            children: [
              // Campo Nombre
              TextFormField(
                initialValue: _nombre,
                decoration: const InputDecoration(
                  labelText: 'Nombre *',
                  border: OutlineInputBorder(),
                  prefixIcon: Icon(Icons.person),
                ),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor ingrese un nombre';
                  }
                  return null;
                },
                onSaved: (value) => _nombre = value!,
              ),
              const SizedBox(height: 16),

              // Campo Edad
              TextFormField(
                initialValue: _edad,
                decoration: const InputDecoration(
                  labelText: 'Edad *',
                  border: OutlineInputBorder(),
                  prefixIcon: Icon(Icons.cake),
                ),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor ingrese la edad';
                  }
                  final edad = int.tryParse(value);
                  if (edad == null || edad <= 0) {
                    return 'La edad debe ser mayor a 0';
                  }
                  if (edad > 120) {
                    return 'Ingrese una edad válida';
                  }
                  return null;
                },
                onSaved: (value) => _edad = value!,
              ),
              const SizedBox(height: 16),

              // Campo Correo
              TextFormField(
                initialValue: _correo,
                decoration: const InputDecoration(
                  labelText: 'Correo Electrónico *',
                  border: OutlineInputBorder(),
                  prefixIcon: Icon(Icons.email),
                ),
                keyboardType: TextInputType.emailAddress,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor ingrese el correo';
                  }
                  if (!_esCorreoValido(value)) {
                    return 'Ingrese un correo electrónico válido';
                  }
                  return null;
                },
                onSaved: (value) => _correo = value!,
              ),
              const SizedBox(height: 20),

              // Género
              Card(
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const Text(
                        'Género *',
                        style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                      ),
                      Row(
                        children: [
                          Expanded(
                            child: RadioListTile(
                              title: const Text('Masculino'),
                              value: 'Masculino',
                              groupValue: _genero,
                              onChanged: (value) => setState(() => _genero = value!),
                            ),
                          ),
                          Expanded(
                            child: RadioListTile(
                              title: const Text('Femenino'),
                              value: 'Femenino',
                              groupValue: _genero,
                              onChanged: (value) => setState(() => _genero = value!),
                            ),
                          ),
                        ],
                      ),
                    ],
                  ),
                ),
              ),

              // Switch Activo
              Card(
                child: SwitchListTile(
                  title: const Text('Usuario Activo'),
                  subtitle: const Text('Los usuarios inactivos no se mostrarán cuando el filtro esté activado'),
                  value: _activo,
                  onChanged: (value) => setState(() => _activo = value),
                ),
              ),

              const SizedBox(height: 30),

              // Botón Guardar
              ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState!.validate()) {
                    _formKey.currentState!.save();
                    final user = User(
                      nombre: _nombre,
                      genero: _genero,
                      activo: _activo,
                      edad: int.parse(_edad),
                      correo: _correo,
                    );
                    Navigator.pop(context, user);
                  }
                },
                style: ElevatedButton.styleFrom(
                  padding: const EdgeInsets.symmetric(vertical: 16),
                ),
                child: Text(
                  widget.usuario == null ? 'Guardar Usuario' : 'Actualizar Usuario',
                  style: const TextStyle(fontSize: 16),
                ),
              ),

              // Botón Cancelar
              TextButton(
                onPressed: () => Navigator.pop(context),
                child: const Text('Cancelar'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}