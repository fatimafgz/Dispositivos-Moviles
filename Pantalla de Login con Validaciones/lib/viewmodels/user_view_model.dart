import 'package:flutter/material.dart';
import '../models/user.dart';

class UserViewModel extends ChangeNotifier {
  final List<User> _usuarios = [];
  bool _mostrarSoloActivos = false;

  List<User> get usuarios {
    if (_mostrarSoloActivos) {
      return _usuarios.where((user) => user.activo).toList();
    }
    return _usuarios;
  }

  bool get mostrarSoloActivos => _mostrarSoloActivos;

  void toggleFiltroActivos() {
    _mostrarSoloActivos = !_mostrarSoloActivos;
    notifyListeners();
  }

  void setFiltroActivos(bool value) {
    _mostrarSoloActivos = value;
    notifyListeners();
  }

  void agregarUsuario(User usuario) {
    _usuarios.add(usuario);
    notifyListeners();
  }

  void editarUsuario(int index, User usuario) {
    // Encontrar el índice real considerando el filtro
    final userRealIndex = _usuarios.indexOf(usuarios[index]);
    _usuarios[userRealIndex] = usuario;
    notifyListeners();
  }

  void eliminarUsuario(int index) {
    // Encontrar el índice real considerando el filtro
    final userRealIndex = _usuarios.indexOf(usuarios[index]);
    _usuarios.removeAt(userRealIndex);
    notifyListeners();
  }
}