import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mi Perfil'),
        backgroundColor: Colors.purple,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          children: [
            const CircleAvatar(
              radius: 70,
              backgroundImage: NetworkImage(
                  'https://cdn.pixabay.com/photo/2016/11/29/13/14/attractive-1869761_640.jpg'),
            ),
            const SizedBox(height: 20),
            const Text(
              'Fatima Florez',
              style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 10),
            const Text(
              'Estudiante de Ingeniería de Software',
              style: TextStyle(fontSize: 16, color: Colors.grey),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 15),
            const Text(
              'Actualmente estoy cursando el sexto semestre de la carrera de ingeniería de software.',
              style: TextStyle(fontSize: 14),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 30),
            Container(
              padding: const EdgeInsets.all(15),
              decoration: BoxDecoration(
                color: Colors.purple.shade50,
                borderRadius: BorderRadius.circular(10),
              ),
              child: Column(
                children: [
                  Row(
                    children: [
                      Icon(Icons.email, color: Colors.purple),
                      const SizedBox(width: 10),
                      const Text('fflorezg@ulasalle.edu.pe'),
                    ],
                  ),
                  const SizedBox(height: 10),
                  Row(
                    children: [
                      Icon(Icons.phone, color: Colors.purple),
                      const SizedBox(width: 10),
                      const Text('+51 999 888 777'),
                    ],
                  ),
                  const SizedBox(height: 10),
                  Row(
                    children: [
                      Icon(Icons.school, color: Colors.purple),
                      const SizedBox(width: 10),
                      const Text('Universidad La Salle'),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}