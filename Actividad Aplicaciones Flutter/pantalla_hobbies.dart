import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mis Hobbies'),
        backgroundColor: Colors.purple,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Mis Actividades Favoritas',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),

            // Hobby 1 - Videojuegos
            Row(
              children: [
                Icon(Icons.sports_esports, color: Colors.yellow, size: 40),
                const SizedBox(width: 15),
                const Expanded(
                  child: Text(
                    'Jugar Videojuegos',
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),

            // Hobby 2 - Música
            Row(
              children: [
                Icon(Icons.music_note, color: Colors.pink, size: 40),
                const SizedBox(width: 15),
                const Expanded(
                  child: Text(
                    'Escuchar Música',
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),

            // Hobby 3 - Maquillarme
            Row(
              children: [
                Icon(Icons.brush, color: Colors.red, size: 40),
                const SizedBox(width: 15),
                const Expanded(
                  child: Text(
                    'Maquillarme',
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),

            // Hobby 4 - Manualidades
            Row(
              children: [
                Icon(Icons.build, color: Colors.orange, size: 40),
                const SizedBox(width: 15),
                const Expanded(
                  child: Text(
                    'Hacer manualidades',
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),
          ],
        ),
      ),
    );
  }
}