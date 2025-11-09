import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Bottom Navigation Practice',
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;
  String _nombreUsuario = 'Usuario';

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  // Lista simple de páginas
  final List<Widget> _pages = [
    // Página 0: Inicio
    const Center(
      child: Text('Página de Inicio', style: TextStyle(fontSize: 24)),
    ),

    // Página 1: Usuarios
    const Center(
      child: Text('Página de Usuarios', style: TextStyle(fontSize: 24)),
    ),

    // Página 2: Configuración
    const Center(
      child: Text('Página de Configuración', style: TextStyle(fontSize: 24)),
    ),

    // Página 3: Perfil (se construye dinámicamente)
    Container(), // Placeholder, se actualiza en build
  ];

  @override
  Widget build(BuildContext context) {
    // Actualizamos la página de perfil con el nombre actual
    _pages[3] = _buildPerfilPage();

    return Scaffold(
      appBar: AppBar(
        title: const Text('Navegación Inferior'),
      ),
      body: _pages[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
        selectedItemColor: Colors.blue,
        unselectedItemColor: Colors.grey,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Inicio',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.people),
            label: 'Usuarios',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.settings),
            label: 'Configuración',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: 'Perfil',
          ),
        ],
      ),
    );
  }

  Widget _buildPerfilPage() {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            'Perfil de $_nombreUsuario',
            style: const TextStyle(fontSize: 24),
          ),
          const SizedBox(height: 20),
          ElevatedButton(
            onPressed: () async {
              final nombre = await Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => const EditarPerfilScreen()),
              );
              if (nombre != null) {
                setState(() {
                  _nombreUsuario = nombre;
                });
              }
            },
            child: const Text('Editar Perfil'),
          ),
        ],
      ),
    );
  }
}

class EditarPerfilScreen extends StatefulWidget {
  const EditarPerfilScreen({super.key});

  @override
  State<EditarPerfilScreen> createState() => _EditarPerfilScreenState();
}

class _EditarPerfilScreenState extends State<EditarPerfilScreen> {
  final TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Editar Perfil'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _controller,
              decoration: const InputDecoration(
                labelText: 'Nombre',
                hintText: 'Escribe tu nombre',
              ),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                if (_controller.text.isNotEmpty) {
                  Navigator.pop(context, _controller.text);
                }
              },
              child: const Text('Guardar'),
            ),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }
}