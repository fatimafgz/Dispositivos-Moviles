/*
Descripción: Piedra, Papel, Tijera - Programa para jugar piedra, papel o tijera, el usuario elige una opción y la computadora selecciona una opción aleatoriamente
Autor: Fatima Florez
Fecha creación: 23/08/2025
Fecha última modificación: 23/08/2025
*/

import kotlin.random.Random


fun main(){
    println("Elige una opción: (0 - Piedra), (1 - Papel), (2 - Tijera)")
    val usuario = readln().toInt()

    // La computadora elige de forma aleatoria un número entre 0 y 2
    val compu = Random.nextInt(3)

    // Muestra elección del usuario
    print("Tú elegiste: ")
    when (usuario) {
        0 -> println("Piedra")
        1 -> println("Papel")
        2 -> println("Tijera")
        else -> {
            println("Opción inválida")
            return
        }
    }

    // Muestra elección de la computadora
    print("La computadora eligió: ")
    when (compu) {
        0 -> println("Piedra")
        1 -> println("Papel")
        2 -> println("Tijera")
    }

    // Determina el resultado de la partida
    if(usuario == compu){
        println("Empate")
    } else if (
        (usuario == 0 && compu == 2) || (usuario == 1 && compu == 0 ) || (usuario == 2 && compu == 1)
    ) {
            println("Ganaste!!")
        } else {
            println("Perdiste :(")
        }
    }
